package com.mall.admin.service.impl;

import com.mall.admin.dao.AdminUserDao;
import com.mall.admin.service.AdminUserService;
import com.mall.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public List<AdminUser> findAll() {
        List<AdminUser> adminUsers = adminUserDao.findAll();
        return adminUsers;
    }

    @Override
    public List<AdminUser> findByPage(int offset, int pageSize) {
        List<AdminUser> adminUsers = adminUserDao.findByPage(offset, pageSize);
        return adminUsers;
    }

    @Override
    public AdminUser findById(int id) {
        AdminUser adminUser = adminUserDao.findById(id);
        return adminUser;
    }

    @Override
    public int save(AdminUser adminUser) {
        int status = adminUserDao.save(adminUser);
        return status;
    }

    @Override
    public void update(AdminUser adminUser) {
        adminUserDao.update(adminUser);
    }

    @Override
    public void delete(AdminUser adminUser) {
        adminUserDao.delete(adminUser);
    }
}
