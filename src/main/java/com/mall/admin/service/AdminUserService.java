package com.mall.admin.service;

import com.mall.model.AdminUser;

import java.util.List;

public interface AdminUserService {

    List<AdminUser> findAll();

    List<AdminUser> findByPage(int offset, int pageSize);

    AdminUser findById(int id);

    int save(AdminUser adminUser);

    void update(AdminUser adminUser);

    void delete(AdminUser adminUser);

}
