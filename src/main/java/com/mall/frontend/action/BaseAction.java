package com.mall.frontend.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;

import java.util.Map;
@Scope("prototype")
public class BaseAction extends ActionSupport {
    public Map<String, Object> jsonResult;
}
