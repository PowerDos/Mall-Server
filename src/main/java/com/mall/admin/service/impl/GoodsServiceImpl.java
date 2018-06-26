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
    public List<Goods> findAll(String orderKeys) {
        List<Goods> goodses = goodsDao.findAll(orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByGoodsName(String goodsName, String orderKeys) {
        List<Goods> goodses = goodsDao.findByGoodsName(goodsName, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize, String orderKeys) {
        List<Goods> goodses = goodsDao.findByGoodsNameAndPage(goodsName, page, pageSize, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByMerchantId(int merchantId, String orderKeys) {
        List<Goods> goodses = goodsDao.findByMerchantId(merchantId, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByMerchantIdAndPage(int merchantId, int page, int pageSize, String orderKeys) {
        List<Goods> goodses = goodsDao.findByMerchantIdAndPage(merchantId, page, pageSize, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByCatId(int catId, String orderKeys) {
        List<Goods> goodses = goodsDao.findByCatId(catId, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByCatIdAndPage(int catId, int page, int pageSize, String orderKeys) {
        List<Goods> goodses = goodsDao.findByCatIdAndPage(catId, page, pageSize, orderKeys);
        return goodses;
    }

    @Override
    public List<Goods> findByPage(int offset, int pageSize, String orderKeys) {
        List<Goods> goodss = goodsDao.findByPage(offset, pageSize, orderKeys);
        return goodss;
    }

    @Override
    public int getCount() {
        return goodsDao.getCount();
    }

    @Override
    public int getCountByGoodsName(String goodsName) {
        return goodsDao.getCountByGoodsName(goodsName);
    }

    @Override
    public int getCountByMerchantId(int merchantId) {
        return goodsDao.getCountByMerchantId(merchantId);
    }

    @Override
    public int getCountByCatId(int catId) {
        return goodsDao.getCountByCatId(catId);
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
