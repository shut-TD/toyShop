package com.toyshop.Interceptor.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class VipIdGennerator implements IdentifierGenerator {
    public static String randomNumber(int num) {
        if (num < 1) {
            num = 1;
        }
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        if (entity.getClass().getName().equals("com.toyshop.Entity.Vip")){
            String randomId = randomNumber(6);
            return "VIP@" + randomId;
        }
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}