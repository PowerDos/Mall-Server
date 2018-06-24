package com.mall.Interceptor;

import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import com.mall.utils.Token;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

public class authInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String token = ServletActionContext.getRequest().getHeader("x-access-token");

        if (token != null) {
            User user = Token.validToken(token, User.class);
            if (user != null) {
                ServletActionContext.getRequest().setAttribute("tokenData", user);
                actionInvocation.invoke();
                return null;
            }
        }
        ActionContext context = ActionContext.getContext();
        ValueStack stack = context.getValueStack();
        stack.set("jsonResult", ResponseTemplate.error(1, "请传输正确token"));
        return "success";
    }
}
