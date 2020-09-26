package com.sgll.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SIGNATURE = "s1g2l3l4";

    /**
     * 生成token  header.payload.signature
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        // 默认 1 天过期
        instance.add(Calendar.DATE,1);
        // 创建 jwt builder
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach((k,v) -> {
            builder.withClaim(k,v);
        });
        // 指定令牌过期时间
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGNATURE));//sign
        return token;
    }

    /**
     * 验证 token 合法性
     * 获取 token 信息
     * @param token
     */
//    public static DecodedJWT verify(String token){
//        // 创建验证对象
//        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
//    }
}
