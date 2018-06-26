package com.mall.admin.service.impl;

import com.mall.admin.dao.GoodsDao;
import com.mall.admin.service.GoodsService;
import com.mall.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findAll() {
        List<Goods> goodses = goodsDao.findAll();
        return goodses;
    }

    @Override
    public List<Goods> findByGoodsName(String goodsName) {
        List<Goods> goodses = goodsDao.findByGoodsName(goodsName);
        return goodses;
    }

    @Override
    public List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize) {
        List<Goods> goodses = goodsDao.findByGoodsNameAndPage(goodsName, page, pageSize);
        return goodses;
    }

    @Override
    public List<Goods> findByCatId(int catId) {
        List<Goods> goodses = goodsDao.findByCatId(catId);
        return goodses;
    }

    @Override
    public List<Goods> findByCatIdAndPage(int catId, int page, int pageSize) {
        List<Goods> goodses = goodsDao.findByCatIdAndPage(catId, page, pageSize);
        return goodses;
    }

    @Override
    public List<Goods> findByPage(int offset, int pageSize) {
        List<Goods> goodss = goodsDao.findByPage(offset, pageSize);
        return goodss;
    }

    @Override
    public Goods findById(int id) {
        Goods goods = goodsDao.findById(id);
        return goods;
    }

    @Override
    public int save(Goods goods) {
        int status = goodsDao.save(goods);
        return status;
    }

    @Override
    public void update(Goods goods) {
        goodsDao.update(goods);
    }

    @Override
    public void delete(Goods goods) {
        goodsDao.delete(goods);
    }
}
