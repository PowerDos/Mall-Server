package com.mall.admin.service.impl;

import com.mall.admin.dao.SecondKillDao;
import com.mall.admin.service.SecondKillService;
import com.mall.model.SecondKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondKillServiceImpl implements SecondKillService {

    @Autowired
    private SecondKillDao secondKillDao;

    @Override
    public List<SecondKill> findAll() {
        List<SecondKill> secondKills = secondKillDao.findAll();
        return secondKills;
    }

    @Override
    public List<SecondKill> findByPage(int offset, int pageSize) {
        List<SecondKill> secondKills = secondKillDao.findByPage(offset, pageSize);
        return secondKills;
    }

    @Override
    public SecondKill findById(int id) {
        SecondKill secondKill = secondKillDao.findById(id);
        return secondKill;
    }

    @Override
    public int save(SecondKill secondKill) {
        int status = secondKillDao.save(secondKill);
        return status;
    }

    @Override
    public void update(SecondKill secondKill) {
        secondKillDao.update(secondKill);
    }

    @Override
    public void delete(SecondKill secondKill) {
        secondKillDao.delete(secondKill);
    }
}
