package com.mall.frontend.service;

import com.mall.model.Address;

import java.util.List;

public interface AddressService {
    int saveAddress(Address address);
    List<Address> getAddress(int userid);
    void delAddress(Address address);
    void editAddress(Address address);
}
