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
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            System.out.println(getParam("goodsName"));
            System.out.println(getParam("page"));
            System.out.println();
            System.out.println(getParam("pageSize"));
            // 根据参数判断用户是否要根据指定值查找
            if (hasParam("goodsName")) {
                System.out.println("Has page and goodsName！");
                goodses = goodsService.findByGoodsNameAndPage(getParam("goodsName"), page, pageSize);
            } else if (hasParam("catId")) {
                System.out.println("Has page and catId！");
                goodses = goodsService.findByCatIdAndPage(Integer.parseInt(getParam("catId")), page, pageSize);
            } else {
                System.out.println("Has page and catId!");
                goodses = goodsService.findByPage(page, pageSize);
            }
        } else {
            if (hasParam("goodsName")) {
                System.out.println("Has goodsName！");
                goodses = goodsService.findByGoodsName(getParam("goodsName"));
            } else if (hasParam("catId")) {
                System.out.println("Has catId！");
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
}
