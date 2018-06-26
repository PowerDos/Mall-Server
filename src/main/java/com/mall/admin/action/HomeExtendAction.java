package com.mall.admin.action;

import com.mall.admin.service.HomeExtendService;
import com.mall.model.HomeExtend;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeExtendAction extends AdminBaseAction {

    @Autowired
    private HomeExtendService homeExtendService;

    private HomeExtend homeExtend;
    private List<HomeExtend> homeExtends;

    public Map<String, Object> jsonResult;

    // 列出所有
    public String list() {
        // 分页设置
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            homeExtends = homeExtendService.findByPage(page, pageSize);
        } else {
            homeExtends = homeExtendService.findAll();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", homeExtends);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.homeExtend == null) {
            jsonResult = ResponseTemplate.error(-1, "Param homeExtend is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        homeExtend = homeExtendService.findById(this.homeExtend.getId());
        map.put("data", homeExtend);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.homeExtend == null) {
            jsonResult = ResponseTemplate.error(-1, "Param homeExtend is required!");
            return SUCCESS;
        }

        int status = homeExtendService.save(this.homeExtend);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", homeExtend);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.homeExtend == null) {
            jsonResult = ResponseTemplate.error(-1, "Param homeExtend is required!");
            return SUCCESS;
        }

        homeExtendService.update(homeExtend);

        Map<String, Object> map = new HashMap<>();
        map.put("data", homeExtend);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.homeExtend == null) {
            jsonResult = ResponseTemplate.error(-1, "Param homeExtend is required!");
            return SUCCESS;
        }

        homeExtendService.delete(this.homeExtend);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setHomeExtend(HomeExtend homeExtend) {
        this.homeExtend = homeExtend;
    }
}
