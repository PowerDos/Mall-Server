package com.mall.admin.dao;


import com.mall.model.Merchant;

import java.util.List;

public interface MerchantDao {

    List<Merchant> findAll();

    List<Merchant> findByPage(int page, int pageSize);

    Merchant findById(int id);

    int save(Merchant merchant);

    void update(Merchant merchant);

    void delete(Merchant merchant);

}
