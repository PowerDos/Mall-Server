package com.mall.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {
    private static final String SECRET = "MallvServersa!@#$#";
    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";
    /**
     * 生成Token:jwt
     * @param object 传入的加密对象 - 放入PAYLOAD
     * @param maxAge 过期事件,单位秒
     * @param <T>
     * @return
     */
    public static <T> String createToken(T object, long maxAge) {
        Date now = new Date();
        Map<String, Object> map = new HashMap<String, Object>();
        String jsonString = JSON.toJSONString(object);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        long exp = now.getTime() + maxAge * 1000;
        String token = null;
        try {
            token = JWT.create()
                    .withHeader(map)//header
                    .withClaim(PAYLOAD, jsonString)//存放的内容 json
                    .withExpiresAt(new Date(exp))
                    .sign(Algorithm.HMAC256(SECRET));//密钥
        } catch (JWTCreationException e) {
            System.out.println(e);
        }
        return token;
    }

    /**
     * 解密token
     * @param token jwt类型的token
     * @param classT 加密时的类型
     * @param <T>
     * @return 返回解密后的对象 - 如果token过期返回空对象
     */
    public static <T> T validToken(String token, Class<T> classT)  {
        DecodedJWT decode = null;
        try {
            decode = JWT.decode(token);
            Map<String, Claim> claims = decode.getClaims();
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
                long tokenTime = claims.get(EXP).asDate().getTime();
                long nowTime = new Date().getTime();
                // 判断令牌是否超时
                if (tokenTime > nowTime){
                    String json = claims.get(PAYLOAD).asString();
                    if (classT != null) {
                        return JSON.parseObject(json, classT);
                    } else {
                        return (T) JSON.parse(json);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
    }
}
