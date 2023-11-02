package com.toyshop.Controller.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JWTUtils {

    /**
     * 自定义秘钥
     * */
    private static final String sign = "Iloveyou" ;

    /**
     * jwtToken的默认有效时间 单位分钟
     * */
    private static final int expireTime = 60 ;
    /**
     * 生成jwt token
     * @param map  要存放负载信息
     * */
    public String createJwtToken(Map<String,Object> map){
        return  Jwts.builder()
                .setClaims(map) //放入payLoad部分的信息
                .signWith(SignatureAlgorithm.HS512,sign)
                .compact();
    }
    /**
     * 从令牌中获取数据,就是payLoad部分存放的数据。如果jwt被改，该函数会直接抛出异常
     * @param token  令牌
     * */
    public Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(sign)
                .parseClaimsJws(token)
                .getBody() ;
    }
    /**
     * 验证用户信息
     * @param token  jwtToken
     * */
    public R verifyJwtToken(String token){
//        claims = {三歪={username=三歪, password=lys666, imgName=null, isadmin=1}}
        try {
            Claims claims = parseToken(token);
            return new R(200);
        } catch (Exception e) {
            return new R(401,"授权失效");
        }
    }

    /**
     * 刷新令牌时间，刷新redis缓存时间
     * @param  user 用户信息
     * */
//    public static void refreshToken(User user){
//        //重新设置User对象的过期时间，再刷新缓存
//        user.setExpireTime(System.currentTimeMillis()+1000L * 60 * expireTime);
//        RedisUtils.saveValue(user.getId(),user,expireTime,TimeUnit.MINUTES);
//    }

    /**
     * 删除 token 的前缀
     * 前端的安全规则会在token前自动生成 Bearer 字符串前缀,共7个字符,需要删掉
     * */
//    public static String replaceTokenPrefix(String token){
//        return  token.substring(7);
//    }
}