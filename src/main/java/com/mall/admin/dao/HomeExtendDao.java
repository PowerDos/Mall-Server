package com.mall.admin.dao;


import com.mall.model.HomeExtend;

import java.util.List;

public interface HomeExtendDao {

    List<HomeExtend> findAll();

    List<HomeExtend> findByPage(int page, int pageSize);

    HomeExtend findById(int id);

    int save(HomeExtend homeExtend);

    void update(HomeExtend homeExtend);

    void delete(HomeExtend homeExtend);

}
