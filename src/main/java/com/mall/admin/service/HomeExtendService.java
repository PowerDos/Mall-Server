package com.mall.admin.service;

import com.mall.model.HomeExtend;

import java.util.List;

public interface HomeExtendService {

    List<HomeExtend> findAll();

    List<HomeExtend> findByPage(int offset, int pageSize);

    HomeExtend findById(int id);

    int save(HomeExtend homeExtend);

    void update(HomeExtend homeExtend);

    void delete(HomeExtend homeExtend);

}
