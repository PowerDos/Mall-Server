package com.mall.admin.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
public class AdminBaseAction extends ActionSupport {

    public int DEFAULT_PAGE = 1;
    public int DEFAULT_PAGE_SIZE = 15;

    protected boolean hasPageSetting() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramPage = req.getParameter("page");
        String paramPageSize = req.getParameter("pageSize");

        return paramPage != null || paramPageSize != null;
    }

    protected int getPageSetting() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramPage= req.getParameter("page");

        if (paramPage == null) {
            return DEFAULT_PAGE;
        }
        return Integer.parseInt(paramPage);
    }

    protected int getPageSizeSetting() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String paramPageSize= req.getParameter("pageSize");

        if (paramPageSize == null) {
            return DEFAULT_PAGE_SIZE;
        }
        return Integer.parseInt(paramPageSize);
    }

}
