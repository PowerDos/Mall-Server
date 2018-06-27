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

        int count;

        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            // 根据参数判断用户是否要根据指定值查找
            if (hasParam("goodsName")) {
                String goodsName = getParam("goodsName");
                goodses = goodsService.findByGoodsNameAndPage(goodsName, page, pageSize, orderKeys);
                count = goodsService.getCountByGoodsName(goodsName);
            } else if (hasParam("catId")) {
                int catId = Integer.parseInt(getParam("catId"));
                goodses = goodsService.findByCatIdAndPage(catId, page, pageSize, orderKeys);
                count = goodsService.getCountByCatId(catId);
            } else if (hasParam("merchantId")) {
                int merchantId = Integer.parseInt(getParam("merchantId"));
                goodses = goodsService.findByMerchantIdAndPage(merchantId, page, pageSize, orderKeys);
                count = goodsService.getCountByMerchantId(merchantId);
            } else {
                goodses = goodsService.findByPage(page, pageSize, orderKeys);
                count = goodsService.getCount();
            }
        } else {
            if (hasParam("goodsName")) {
                String goodsName = getParam("goodsName");
                goodses = goodsService.findByGoodsName(getParam("goodsName"), orderKeys);
                count = goodsService.getCountByGoodsName(goodsName);
            } else if (hasParam("catId")) {
                int catId = Integer.parseInt(getParam("catId"));
                goodses = goodsService.findByCatId(Integer.parseInt(getParam("catId")), orderKeys);
                count = goodsService.getCountByCatId(catId);
            } else if (hasParam("merchantId")) {
                int merchantId = Integer.parseInt("merchantId");
                goodses = goodsService.findByMerchantId(Integer.parseInt(getParam("merchantId")), orderKeys);
                count = goodsService.getCountByMerchantId(merchantId);
            } else {
                goodses = goodsService.findAll(orderKeys);
                count = goodsService.getCount();
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodses);

        // 加上商品总数
        map.put("goodsSum", count);
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
        System.out.println(goods.getGoodsAttrs().size());
        System.out.println(goods.getGoodsName());
        System.out.println(goods.getGoodsImgs());
        System.out.println(goods.getGoodsDesc());

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
