package com.toyshop.Controller;

import com.toyshop.Controller.utils.R;
import com.toyshop.Dao.userDao;
import com.toyshop.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterController {

    @Autowired
    private userDao userDao;

    @PostMapping("/register")
    public R userReg(@RequestBody User user){
        if (userDao.isExists(user.getUsername()) == null){
            userDao.insertUser(user);
            return new R(200,"注册成功");
        }else {
            return new R(400,"用户名已存在");
        }
    }
}
