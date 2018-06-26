package com.mall.admin.action;

import com.mall.admin.service.GoodsCatService;
import com.mall.model.GoodsCat;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsCatAction extends AdminBaseAction {

    @Autowired
    private GoodsCatService goodsCatService;

    private GoodsCat goodsCat;
    private List<GoodsCat> goodsCats;

    public Map<String, Object> jsonResult;

    // 列出所有
    public String list() {
        goodsCats = goodsCatService.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodsCats);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.goodsCat == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goodsCat is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        goodsCat = goodsCatService.findById(this.goodsCat.getId());
        map.put("data", goodsCat);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.goodsCat == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goodsCat is required!");
            return SUCCESS;
        }

        int status = goodsCatService.save(this.goodsCat);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", goodsCat);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.goodsCat == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goodsCat is required!");
            return SUCCESS;
        }

        goodsCatService.update(goodsCat);

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodsCat);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.goodsCat == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goodsCat is required!");
            return SUCCESS;
        }

        goodsCatService.delete(this.goodsCat);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setGoodsCat(GoodsCat goodsCat) {
        this.goodsCat = goodsCat;
    }
}
