package com.toyshop.Service.serviceImpl;

import com.toyshop.Controller.utils.R;
import com.toyshop.Dao.userDao;
import com.toyshop.Entity.User;
import com.toyshop.Service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class registerImpl implements registerService {

    @Autowired
    private userDao userDao;

    @Override
    public R userCheck(String username){
        if (userDao.isExists(username) == null){
            return new R(200);
        }else return new R(400);
    }

    @Override
    public R userRegister(User user){
        if (userDao.insertUser(user)){
            return new R(200,"注册成功");
        }else return new R(400,"注册失败(可能为重复账号)");
    }
}
