package com.mall.admin.service.impl;

import com.mall.admin.dao.HomeExtendDao;
import com.mall.admin.service.HomeExtendService;
import com.mall.admin.service.HomeExtendService;
import com.mall.model.HomeExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeExtendServiceImpl implements HomeExtendService {

    @Autowired
    private HomeExtendDao homeExtendDao;

    @Override
    public List<HomeExtend> findAll() {
        List<HomeExtend> homeExtends = homeExtendDao.findAll();
        return homeExtends;
    }

    @Override
    public List<HomeExtend> findByPage(int offset, int pageSize) {
        List<HomeExtend> homeExtends = homeExtendDao.findByPage(offset, pageSize);
        return homeExtends;
    }

    @Override
    public HomeExtend findById(int id) {
        HomeExtend homeExtend = homeExtendDao.findById(id);
        return homeExtend;
    }

    @Override
    public int save(HomeExtend homeExtend) {
        int status = homeExtendDao.save(homeExtend);
        return status;
    }

    @Override
    public void update(HomeExtend homeExtend) {
        homeExtendDao.update(homeExtend);
    }

    @Override
    public void delete(HomeExtend homeExtend) {
        homeExtendDao.delete(homeExtend);
    }
}
