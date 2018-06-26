package com.mall.frontend.action;

import com.mall.admin.service.GoodsService;
import com.mall.frontend.service.GoodsCommentService;
import com.mall.model.Goods;
import com.mall.model.GoodsComment;
import com.mall.utils.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller(value = "goodsCommentAction")
public class GoodsCommentAction extends BaseAction {

    private GoodsComment goodsComment;

    private List<GoodsComment> goodsComments;

    @Autowired
    private GoodsCommentService goodsCommentService;

    @Autowired
    private GoodsService goodsService;

    public Map<String, Object> jsonResult;

    public String list() {
        if (!hasParam("goodsId")) {
            jsonResult = ResponseTemplate.error(-1, "param goodsId is required!");
            return SUCCESS;
        }

        int count = 0;

        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            if (hasParam("goodsId") && hasParam("commentLevel")) {
                int goodsId = Integer.parseInt(getParam("goodsId"));
                int commentLevel = Integer.parseInt(getParam("commentLevel"));

                goodsComments = goodsCommentService.findByGoodsIdAndCommentLevelAndPage(goodsId, commentLevel, page, pageSize);
                count = goodsCommentService.getCountByGoodsIdAndCommentLevel(goodsId, commentLevel);
            } else if (hasParam("goodsId")) {
                int goodsId = Integer.parseInt(getParam("goodsId"));

                goodsComments = goodsCommentService.findByGoodsIdAndPage(goodsId, page, pageSize);
                count = goodsCommentService.getCountByGoodsId(goodsId);
            }
        } else {
            if (hasParam("goodsId") && hasParam("commentLevel")) {
                int goodsId = Integer.parseInt(getParam("goodsId"));
                int commmentLevel = Integer.parseInt(getParam("commentLevel"));

                goodsComments = goodsCommentService.findByGoodsIdAndCommentLevel(goodsId, commmentLevel);
                count = goodsCommentService.getCountByGoodsIdAndCommentLevel(goodsId, commmentLevel);
            } else if (hasParam("goodsId")) {
                int goodsId = Integer.parseInt(getParam("goodsId"));

                goodsComments = goodsCommentService.findByGoodsId(goodsId);
                count = goodsCommentService.getCountByGoodsId(goodsId);
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", goodsComments);
        map.put("count", count);

        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public String add() {
        if (this.goodsComment == null) {
            jsonResult = ResponseTemplate.error(-1, "param goodsComment is required!");
            return SUCCESS;
        }

        int status = goodsCommentService.save(goodsComment);

        // Update related goods
        Goods goods = goodsService.findById(goodsComment.getGoodsId());
        Set<GoodsComment> commentSet = new HashSet<>(goods.getGoodsComments());
        commentSet.add(goodsComment);
        goods.setGoodsComments(commentSet);
        goodsService.update(goods);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", goodsComment);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    public void setGoodsComment(GoodsComment goodsComment) {
        this.goodsComment = goodsComment;
    }

}
