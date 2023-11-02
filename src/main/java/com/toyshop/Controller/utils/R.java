package com.toyshop.Controller.utils;

import lombok.Data;

//状态码：
//成功：200
//服务器故障：500
//未授权：401
//禁止访问：403
//token重复：400
@Data
public class R {
    private int statusCode;
    private Object data;
    private String msg;

    public R(){}

    public R(int statusCode){
        this.statusCode = statusCode;
    }

    public R(int statusCode,Object data){
        this.statusCode = statusCode;
        this.data = data;
    }

    public R(String msg){
        this.statusCode = 400;
        this.msg = msg;
    }

    public R(int statusCode,String msg){
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public R(int statusCode,Object data,String msg){
        this.statusCode = statusCode;
        this.data = data;
        this.msg = msg;
    }
}
