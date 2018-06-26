package com.mall.admin.service;

import com.mall.model.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAll(String orderKeys);

    List<Goods> findByGoodsName(String goodsName, String orderKeys);

    List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize, String orderKeys);

    List<Goods> findByMerchantId(int merchantId, String orderKeys);

    List<Goods> findByMerchantIdAndPage(int merchantId, int page, int pageSize, String orderKeys);

    List<Goods> findByCatId(int catId, String orderKeys);

    List<Goods> findByCatIdAndPage(int catId, int page, int pageSize, String orderKeys);

    List<Goods> findByPage(int offset, int pageSize, String orderKeys);

    Goods findById(int id);

    int save(Goods adminUser);

    void update(Goods adminUser);

    void delete(Goods adminUser);

}
