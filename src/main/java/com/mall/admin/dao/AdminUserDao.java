package com.mall.admin.dao;

import com.mall.model.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserDao {

    List<AdminUser> findAll();

    List<AdminUser> findByPage(int offset, int pageSize);

    AdminUser findById(int id);

    int save(AdminUser adminUser);

    void update(AdminUser adminUser);

    void delete(AdminUser adminUser);

}
