package com.mall.frontend.service.impl;

import com.mall.frontend.dao.GoodsCommentDao;
import com.mall.frontend.service.GoodsCommentService;
import com.mall.model.GoodsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    private GoodsCommentDao goodsCommentDao;

    @Override
    public List<GoodsComment> findByGoodsId(int goodsId) {
        return goodsCommentDao.findByGoodsId(goodsId);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndPage(int goodsId, int page, int pageSize) {
        return goodsCommentDao.findByGoodsIdAndPage(goodsId, page, pageSize);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndCommentLevel(int goodsId, int commentLevel) {
        return goodsCommentDao.findByGoodsIdAndCommentLevel(goodsId, commentLevel);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndCommentLevelAndPage(int goodsId, int commentLevel, int page, int pageSize) {
        return goodsCommentDao.findByGoodsIdAndCommentLevelAndPage(goodsId, commentLevel, page, pageSize);
    }

    @Override
    public int getCount() {
        return goodsCommentDao.getCount();
    }

    @Override
    public int getCountByGoodsId(int goodsId) {
        return goodsCommentDao.getCountByGoodsId(goodsId);
    }

    @Override
    public int getCountByCommentLevel(int commentLevel) {
        return goodsCommentDao.getCountByCommentLevel(commentLevel);
    }

    @Override
    public int getCountByGoodsIdAndCommentLevel(int goodsId, int commentLevel) {
        return goodsCommentDao.getCountByGoodsIdAndCommentLevel(goodsId, commentLevel);
    }

    @Override
    public int save(GoodsComment goodsComment) {
        return goodsCommentDao.save(goodsComment);
    }
}
