package com.mall.admin.action;

import com.mall.admin.service.GoodsService;
import com.mall.model.Goods;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsAction extends AdminBaseAction {

    @Autowired
    private GoodsService goodsService;

    private Goods goods;
    private List<Goods> goodses;

    public Map<String, Object> jsonResult;

    public String list() {
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            System.out.println(getParam("goodsName"));
            System.out.println(getParam("page"));
            System.out.println(getParam("pageSize"));
            // 根据参数判断用户是否要根据指定值查找
            if (hasParam("goodsName")) {
                System.out.println("Has page and goodsName");
                goodses = goodsService.findByGoodsNameAndPage(getParam("goodsName"), page, pageSize);
            } else if (hasParam("catId")) {
                System.out.println("Has page and catId");
                goodses = goodsService.findByCatIdAndPage(Integer.parseInt(getParam("catId")), page, pageSize);
            } else {
                System.out.println("Has page and catId");
                goodses = goodsService.findByPage(page, pageSize);
            }
        } else {
            if (hasParam("goodsName")) {
                System.out.println("Has goodsName");
                goodses = goodsService.findByGoodsName(getParam("goodsName"));
            } else if (hasParam("catId")) {
                System.out.println("Has catId");
                goodses = goodsService.findByCatId(Integer.parseInt(getParam("catId")));
            } else {
                System.out.println("find all");
                goodses = goodsService.findAll();
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodses);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.goods == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goods is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        goods = goodsService.findById(this.goods.getId());
        map.put("data", goods);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.goods == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goods is required!");
            return SUCCESS;
        }

        int status = goodsService.save(this.goods);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", goods);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.goods == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goods is required!");
            return SUCCESS;
        }

        goodsService.update(goods);

        Map<String, Object> map = new HashMap<>();
        map.put("data", goods);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.goods == null) {
            jsonResult = ResponseTemplate.error(-1, "Param goods is required!");
            return SUCCESS;
        }

        goodsService.delete(this.goods);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
