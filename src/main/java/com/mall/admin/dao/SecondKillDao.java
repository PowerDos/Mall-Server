package com.mall.admin.dao;


import com.mall.model.SecondKill;

import java.util.List;

public interface SecondKillDao {

    List<SecondKill> findAll();

    List<SecondKill> findByPage(int page, int pageSize);

    SecondKill findById(int id);

    int save(SecondKill secondKill);

    void update(SecondKill secondKill);

    void delete(SecondKill secondKill);

}
