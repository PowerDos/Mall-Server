package com.mall.frontend.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Scope("prototype")
public class BaseAction extends ActionSupport {
    public Map<String, Object> jsonResult;
    public int DEFAULT_PAGE = 1;
    public int DEFAULT_PAGE_SIZE = 15;

    // 检查是否有 Page 相关参数
    protected boolean hasParam(String paramName) {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramValue = req.getParameter(paramName);

        return !(paramValue == null);
    }

    // 检查是否有 Page 相关参数
    protected boolean hasPageSetting() {
        return hasParam("page") || hasParam("pageSize");
    }

    // 获取参数
    protected String getParam(String paramName) {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramValue = req.getParameter(paramName);
        return paramValue;
    }

    // 获取 Page 配置
    protected int getPageSetting() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramPage= req.getParameter("page");

        if (paramPage == null) {
            return DEFAULT_PAGE;
        }
        return Integer.parseInt(paramPage);
    }

    // 获取 PageSize 配置
    protected int getPageSizeSetting() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramPageSize= req.getParameter("pageSize");

        if (paramPageSize == null) {
            return DEFAULT_PAGE_SIZE;
        }
        return Integer.parseInt(paramPageSize);
    }
}
