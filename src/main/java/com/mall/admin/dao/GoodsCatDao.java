package com.mall.admin.dao;


import com.mall.model.GoodsCat;

import java.util.List;

public interface GoodsCatDao {

    List<GoodsCat> findAll();

    List<GoodsCat> findByParentId(int catId);

    GoodsCat findById(int id);

    int save(GoodsCat goodsCat);

    void update(GoodsCat goodsCat);

    void delete(GoodsCat goodsCat);

}
