package com.mall.frontend.action;

import com.mall.admin.service.GoodsService;
import com.mall.model.Goods;
import com.mall.utils.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "uGoodsAction")
public class GoodsAction extends BaseAction {
    @Autowired
    private GoodsService goodsService;

    private Goods goods;
    private List<Goods> goodses;

    private int goodsId;
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    public String list() {
        String orderKeys;

        // 默认按照销售总数排序
        if (hasParam("order")) {
            orderKeys = getParam("order");
        } else {
            orderKeys = "-salesNum";
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
                System.out.println("merchantId");
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
                System.out.println("merchantId");
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

    public String one () {
        Map<String, Object> map = new HashMap<>();
        goods = goodsService.findById(goodsId);
        map.put("data", goods);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }
}
