package com.mall.admin.service;

import com.mall.model.GoodsCat;

import java.util.List;

public interface GoodsCatService {

    List<GoodsCat> findAll();

    GoodsCat findById(int id);

    int save(GoodsCat goodsCat);

    void update(GoodsCat goodsCat);

    void delete(GoodsCat goodsCat);

}
