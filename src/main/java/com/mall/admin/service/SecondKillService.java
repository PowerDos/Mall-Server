package com.mall.admin.service;

import com.mall.model.SecondKill;

import java.util.List;

public interface SecondKillService {

    List<SecondKill> findAll();

    List<SecondKill> findByPage(int offset, int pageSize);

    SecondKill findById(int id);

    int save(SecondKill secondKill);

    void update(SecondKill secondKill);

    void delete(SecondKill secondKill);

}
