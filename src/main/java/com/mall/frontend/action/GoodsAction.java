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
                System.out.println("goodsName!");
            } else if (hasParam("catId")) {
                goodses = goodsService.findByCatIdAndPage(Integer.parseInt(getParam("catId")), page, pageSize, orderKeys);
            } else if (hasParam("merchantId")) {
                goodses = goodsService.findByMerchantIdAndPage(Integer.parseInt(getParam("merchantId")), page, pageSize, orderKeys);
                System.out.println("merchantId");
            } else {
                goodses = goodsService.findByPage(page, pageSize, orderKeys);
            }
        } else {
            if (hasParam("goodsName")) {
                goodses = goodsService.findByGoodsName(getParam("goodsName"), orderKeys);
            } else if (hasParam("catId")) {
                goodses = goodsService.findByCatId(Integer.parseInt(getParam("catId")), orderKeys);
                System.out.println("catId!");
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
}
