package com.mall.frontend.dao;

import com.mall.model.Address;

import java.util.List;

public interface AddressDao {
    int save(Address address);
    List<Address> list(int userid);
    void delete(Address address);
    void update(Address address);
}
