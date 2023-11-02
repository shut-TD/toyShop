package com.toyshop.Service;

import com.toyshop.Controller.utils.R;
import com.toyshop.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
    R userLogin(String username,String password);
    R userTokenCreate(User user);
    R userTokenCheck(User user);
}
