package com.toyshop.Service.serviceImpl;

import com.toyshop.Controller.utils.JWTUtils;
import com.toyshop.Controller.utils.R;
import com.toyshop.Controller.utils.RedisUtils;
import com.toyshop.Dao.userDao;
import com.toyshop.Entity.User;
import com.toyshop.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class loginImpl implements loginService {

    @Autowired
    private userDao userDao;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public R userLogin(String username,String password) {
        if (userDao.checkLogin(username,password) == null){
            return new R(400,"用户名或密码错误");
        }else return new R(200,"登陆成功");
    }

    @Override
    public R userTokenCreate(User user) {
        Map<String,Object> userMap = new HashMap<>();
        userMap.put(user.getUsername(),user);
        //先redis查询是否已生成有效token
        Object csrfToken = redisUtils.get(user.getUsername());
        if (csrfToken != null){
            return new R(400,"已授权");
        }else{
            String userToken = jwtUtils.createJwtToken(userMap);
            redisUtils.set(user.getUsername(),userToken,60L * 60);  //默认60分钟过期
            return new R(200);
        }
    }

    @Override
    public R userTokenCheck(User user) {
        Object checkToken = redisUtils.get(user.getUsername());
        if (checkToken != null){
            return jwtUtils.verifyJwtToken((String) checkToken);
        }else return new R(401,"未授权");
    }
}
