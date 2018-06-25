package com.mall.admin.service;

import com.mall.model.AdminGroup;

import java.util.List;

public interface AdminGroupService {

    List<AdminGroup> findAll();

    List<AdminGroup> findByPage(int offset, int pageSize);

    AdminGroup findById(int id);

    int save(AdminGroup adminGroup);

    void update(AdminGroup adminGroup);

    void delete(AdminGroup adminGroup);

}
