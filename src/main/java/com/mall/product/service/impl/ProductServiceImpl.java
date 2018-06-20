package com.mall.product.service.impl;

import com.mall.product.dao.ProductDao;
import com.mall.product.model.Product;
import com.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

}
