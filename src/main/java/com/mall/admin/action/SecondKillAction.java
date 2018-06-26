package com.mall.admin.action;

import com.mall.admin.service.SecondKillService;
import com.mall.model.SecondKill;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondKillAction extends AdminBaseAction {

    @Autowired
    private SecondKillService secondKillService;

    private SecondKill secondKill;
    private List<SecondKill> secondKills;

    public Map<String, Object> jsonResult;

    // 列出所有
    public String list() {
        // 分页设置
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            secondKills = secondKillService.findByPage(page, pageSize);
        } else {
            secondKills = secondKillService.findAll();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", secondKills);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.secondKill == null) {
            jsonResult = ResponseTemplate.error(-1, "Param secondKill is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        secondKill = secondKillService.findById(this.secondKill.getId());
        map.put("data", secondKill);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.secondKill == null) {
            jsonResult = ResponseTemplate.error(-1, "Param secondKill is required!");
            return SUCCESS;
        }

        int status = secondKillService.save(this.secondKill);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", secondKill);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.secondKill == null) {
            jsonResult = ResponseTemplate.error(-1, "Param secondKill is required!");
            return SUCCESS;
        }

        secondKillService.update(secondKill);

        Map<String, Object> map = new HashMap<>();
        map.put("data", secondKill);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.secondKill == null) {
            jsonResult = ResponseTemplate.error(-1, "Param secondKill is required!");
            return SUCCESS;
        }

        secondKillService.delete(this.secondKill);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setSecondKill(SecondKill secondKill) {
        this.secondKill = secondKill;
    }
}
