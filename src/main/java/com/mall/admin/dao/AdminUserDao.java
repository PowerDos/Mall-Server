package com.mall.admin.dao;

import com.mall.model.AdminUser;

import java.util.List;

public interface AdminUserDao {

    List<AdminUser> findAll();

    List<AdminUser> findByPage(int page, int pageSize);

    AdminUser findById(int id);

    int save(AdminUser adminUser);

    void update(AdminUser adminUser);

    void delete(AdminUser adminUser);

}
