package com.mall.admin.service.impl;

import com.mall.admin.dao.MerchantDao;
import com.mall.admin.service.MerchantService;
import com.mall.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    public List<Merchant> findAll() {
        List<Merchant> merchants = merchantDao.findAll();
        return merchants;
    }

    @Override
    public List<Merchant> findByPage(int offset, int pageSize) {
        List<Merchant> merchants = merchantDao.findByPage(offset, pageSize);
        return merchants;
    }

    @Override
    public Merchant findById(int id) {
        Merchant merchant = merchantDao.findById(id);
        return merchant;
    }

    @Override
    public int save(Merchant merchant) {
        int status = merchantDao.save(merchant);
        return status;
    }

    @Override
    public void update(Merchant merchant) {
        merchantDao.update(merchant);
    }

    @Override
    public void delete(Merchant merchant) {
        merchantDao.delete(merchant);
    }
}
