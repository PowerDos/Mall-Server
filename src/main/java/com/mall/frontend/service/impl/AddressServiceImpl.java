package com.mall.frontend.service.impl;

import com.mall.frontend.dao.AddressDao;
import com.mall.frontend.service.AddressService;
import com.mall.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public int saveAddress(Address address) {
        int result = addressDao.save(address);
        return result;
    }

    @Override
    public List<Address> getAddress(int userid) {
        List<Address> list = addressDao.list(userid);
        return list;
    }

    @Override
    public void delAddress(Address address) {
        addressDao.delete(address);
    }

    @Override
    public void editAddress(Address address) {
        addressDao.update(address);
    }


}
