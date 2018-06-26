package com.mall.frontend.dao;

import com.mall.model.GoodsComment;

import java.util.List;

public interface GoodsCommentDao {

    List<GoodsComment> findByGoodsId(int goodsId);

    List<GoodsComment> findByGoodsIdAndPage(int goodsId, int page, int pageSize);

    List<GoodsComment> findByGoodsIdAndCommentLevel(int goodsId, int commentLevel);

    List<GoodsComment> findByGoodsIdAndCommentLevelAndPage(int goodsId, int commentLevel, int page, int pageSize);

    int getCount();

    int getCountByGoodsId(int goodsId);

    int getCountByCommentLevel(int commentLevel);

    int getCountByGoodsIdAndCommentLevel(int goodsId, int commentLevel);

    int save(GoodsComment goodsComment);

}
