package com.mall.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseTemplate {
    public static Map<String, Object> success(Map<String, Object> result) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("rcode", 0);
        data.put("message", "success");
        data.put("result", result);
        return data;
    }

    public static Map<String, Object> error(int rcode, String message) {
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("rcode", rcode);
        data.put("message", message);
        return data;
    }
}
