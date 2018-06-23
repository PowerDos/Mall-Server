package com.mall.handler;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.rest.handler.ContentTypeHandler;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Json Handler
 *
 * 这个 Handler 是为了优化 struts-rest-plugin
 * 返回 json 数据格式的不足
 *
 */
public class JsonHandler implements ContentTypeHandler {
    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public String fromObject(Object obj, String resultCode, Writer out)
            throws IOException {
        if (obj != null) {
            JacksonFactory.getObjectMapper().writeValue(out, obj);
        }
        return null;
    }

    @Override
    public String fromObject(ActionInvocation actionInvocation, Object o, String s, Writer writer) throws IOException {
        return this.fromObject(o, s, writer);
    }

    @Override
    public void toObject(Reader in, Object target) {
        try {
            System.out.println("Pass json handler");

            Object origin = JacksonFactory.getObjectMapper().readValue(in,
                    target.getClass());
            BeanUtils.copyProperties(origin, target);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    @Override
    public void toObject(ActionInvocation actionInvocation, Reader reader, Object o) throws IOException {
        this.toObject(reader, o);
    }

    public String getContentType() {
        return "application/json;charset=UTF-8";
    }

    public String getExtension() {
        return "json";
    }

}
