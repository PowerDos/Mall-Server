package com.mall.handler;

import org.codehaus.jackson.map.ObjectMapper;


/**
 * Jackson 工厂
 *
 * 提供工厂方法来实例化，避免重复实例化多个 ObjectMapper
 *
 */
public class JacksonFactory {

    private JacksonFactory() {

    }

    private static ObjectMapper objectMapper = null;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

}
