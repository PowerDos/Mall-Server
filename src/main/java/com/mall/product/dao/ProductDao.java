package com.mall.product.dao;


import com.mall.product.model.Product;

/**
 * 商品操作-持久层接口
 *
 */
public interface ProductDao {

    void saveProduct(Product product);

}
