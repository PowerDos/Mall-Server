package com.mall.example.dao;


import com.mall.example.model.Product;

/**
 * 商品操作-持久层接口
 *
 */
public interface ProductDao {

    void saveProduct(Product product);

}
