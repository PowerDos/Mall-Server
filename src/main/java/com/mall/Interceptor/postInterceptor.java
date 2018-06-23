package com.mall.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import java.util.HashMap;
import java.util.Map;

public class postInterceptor extends AbstractInterceptor {
    /**
     * 只允许POST访问拦截器
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String method = ServletActionContext.getRequest().getMethod();
        System.out.println(method);
        if (method.equals("POST")) {
            actionInvocation.invoke();
            return null;
        } else {
            ActionContext context = ActionContext.getContext();
            Map<String, Object> jsonResult = new HashMap<String, Object>();
            jsonResult.put("rcode", 1);
            jsonResult.put("message", "just allow post method");
            jsonResult.put("result", "");
            ValueStack stack = context.getValueStack();
            stack.set("jsonResult", jsonResult);
            return "success";
        }
    }
}
