package com.mall.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
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
        // 解决跨域
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        res.setHeader("Access-Control-Expose-Headers", "*");

        String method = ServletActionContext.getRequest().getMethod();
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
