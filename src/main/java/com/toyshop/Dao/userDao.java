package com.toyshop.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toyshop.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao extends BaseMapper<User> {
    User isExists(String username);
    boolean insertUser(User user);
    User checkLogin(String username, String password);
    int isAdmin(String username);
    String checkImg(String username);
    boolean updateInfo(String username,String password,String imgName);
}
