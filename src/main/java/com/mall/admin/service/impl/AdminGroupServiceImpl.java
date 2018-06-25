package com.mall.admin.service.impl;

import com.mall.admin.dao.AdminGroupDao;
import com.mall.admin.service.AdminGroupService;
import com.mall.model.AdminGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminGroupServiceImpl implements AdminGroupService {

    @Autowired
    private AdminGroupDao adminGroupDao;

    @Override
    public List<AdminGroup> findAll() {
        List<AdminGroup> adminGroups = adminGroupDao.findAll();
        return adminGroups;
    }

    @Override
    public List<AdminGroup> findByPage(int offset, int pageSize) {
        List<AdminGroup> adminGroups = adminGroupDao.findByPage(offset, pageSize);
        return adminGroups;
    }

    @Override
    public AdminGroup findById(int id) {
        AdminGroup adminGroup = adminGroupDao.findById(id);
        return adminGroup;
    }

    @Override
    public int save(AdminGroup adminGroup) {
        int status = adminGroupDao.save(adminGroup);
        return status;
    }

    @Override
    public void update(AdminGroup adminGroup) {
        adminGroupDao.update(adminGroup);
    }

    @Override
    public void delete(AdminGroup adminGroup) {
        adminGroupDao.delete(adminGroup);
    }
}
