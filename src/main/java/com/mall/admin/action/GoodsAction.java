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
        String orderKeys;

        // 默认按照销售总数排序
        if (hasParam("order")) {
            orderKeys = getParam("order");
        } else {
            orderKeys = "salesNum";
        }

        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            // 根据参数判断用户是否要根据指定值查找
            if (hasParam("goodsName")) {
                goodses = goodsService.findByGoodsNameAndPage(getParam("goodsName"), page, pageSize, orderKeys);
            } else if (hasParam("catId")) {
                goodses = goodsService.findByCatIdAndPage(Integer.parseInt(getParam("catId")), page, pageSize, orderKeys);
            } else if (hasParam("merchantId")) {
                goodses = goodsService.findByMerchantIdAndPage(Integer.parseInt(getParam("merchantId")), page, pageSize, orderKeys);
            } else {
                goodses = goodsService.findByPage(page, pageSize, orderKeys);
            }
        } else {
            if (hasParam("goodsName")) {
                goodses = goodsService.findByGoodsName(getParam("goodsName"), orderKeys);
            } else if (hasParam("catId")) {
                goodses = goodsService.findByCatId(Integer.parseInt(getParam("catId")), orderKeys);
            } else if (hasParam("merchantId")) {
                goodses = goodsService.findByMerchantId(Integer.parseInt(getParam("merchantId")), orderKeys);
            } else {
                goodses = goodsService.findAll(orderKeys);
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodses);

        // 加上商品总数
        map.put("goodsSum", goodses.size());
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
