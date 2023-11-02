package com.toyshop.Service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toyshop.Dao.userDao;
import com.toyshop.Entity.User;
import com.toyshop.Service.userService;
import org.springframework.stereotype.Service;

@Service
public class userImpl extends ServiceImpl<userDao, User> implements userService {
}
