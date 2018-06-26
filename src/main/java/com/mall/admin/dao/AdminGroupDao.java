package com.mall.admin.dao;

import com.mall.model.AdminGroup;

import java.util.List;

public interface AdminGroupDao {

    List<AdminGroup> findAll();

    List<AdminGroup> findByPage(int page, int pageSize);

    AdminGroup findById(int id);

    int save(AdminGroup adminGroup);

    void update(AdminGroup adminGroup);

    void delete(AdminGroup adminGroup);

}
