package com.mall.admin.service;

import com.mall.model.Merchant;

import java.util.List;

public interface MerchantService {

    List<Merchant> findAll();

    List<Merchant> findByPage(int offset, int pageSize);

    Merchant isAllowLogin(String merchantName, String password);

    Merchant findById(int id);

    int save(Merchant merchant);

    void update(Merchant merchant);

    void delete(Merchant merchant);

}
