package com.toyshop.Service;

import com.toyshop.Controller.utils.R;
import com.toyshop.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface registerService {
    R userCheck(String username);
    R userRegister(User user);
}
