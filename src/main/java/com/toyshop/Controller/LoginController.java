package com.toyshop.Controller;

import com.toyshop.Controller.utils.JWTUtils;
import com.toyshop.Controller.utils.R;
import com.toyshop.Controller.utils.RedisUtils;
import com.toyshop.Dao.userDao;
import com.toyshop.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private userDao userDao;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/auth")
    public R authBefore(String currentUsername){
        if (redisUtils.get(currentUsername) != null){
            R authR = jwtUtils.verifyJwtToken((String) redisUtils.get(currentUsername));
            if (authR.getStatusCode() == 200){
                return new R(400,"重复登陆");
            }
        }
        return new R(401,"未授权");
    }

    @PostMapping("/login")
    public R userLogin(HttpServletRequest httpServletRequest,@RequestParam String username, @RequestParam String password){
        if (userDao.isExists(username) == null){
            return new R(400,"登陆失败");
        }else {
            if (userDao.checkLogin(username,password) == null){
                return new R(400,"登陆失败");
            }else {
                R AuthBefore = authBefore(username);
                if (AuthBefore.getStatusCode() == 400) return AuthBefore;
                httpServletRequest.getSession().setAttribute("userAuth",userDao.checkLogin(username,password));
                HashMap<String,Object> userMap = new HashMap<>();
                userMap.put("userToken",userDao.checkLogin(username,password));
                String userToken = jwtUtils.createJwtToken(userMap);
                redisUtils.set(username,userToken,60L * 60);
                return new R(200,"登陆成功");
            }
        }
    }

    @GetMapping("/logout")
    public R userLogout(HttpServletRequest httpServletRequest){
        User user = (User) httpServletRequest.getSession().getAttribute("userAuth");
        redisUtils.delete(user.getUsername());
        httpServletRequest.getSession().removeAttribute("userAuth");
        return new R(200,"登出成功");
    }
}
