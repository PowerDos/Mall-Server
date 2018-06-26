package com.mall.admin.service;

import com.mall.model.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAll();

    List<Goods> findByGoodsName(String goodsName);

    List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize);

    List<Goods> findByCatId(int catId);

    List<Goods> findByCatIdAndPage(int catId, int page, int pageSize);

    List<Goods> findByPage(int offset, int pageSize);

    Goods findById(int id);

    int save(Goods adminUser);

    void update(Goods adminUser);

    void delete(Goods adminUser);

}
