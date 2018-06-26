package com.mall.admin.dao;


import com.mall.model.Goods;

import java.util.List;

public interface GoodsDao {

    List<Goods> findAll();

    List<Goods> findByGoodsName(String goodsName);

    List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize);

    List<Goods> findByCatId(int catId);

    List<Goods> findByCatIdAndPage(int catId, int page, int pageSize);

    List<Goods> findByPage(int page, int pageSize);

    Goods findById(int id);

    int save(Goods goods);

    void update(Goods goods);

    void delete(Goods goods);

}
