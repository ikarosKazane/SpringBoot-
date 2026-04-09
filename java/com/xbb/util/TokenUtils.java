package com.xbb.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtils {

    //生成token(数据加密又叫做签名sign)
    public static String sign(String text, String password) {
        //创建算法实例
        Algorithm algorithm = Algorithm.HMAC256(password);
        //System.out.println("token生成前……");
        try {
            String token = JWT.create()
                    .withIssuer(text)//设置自定义参数（负载）
                    .sign(algorithm);//头
            //System.out.println("token生成后……");
            System.out.println("token:" + token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
