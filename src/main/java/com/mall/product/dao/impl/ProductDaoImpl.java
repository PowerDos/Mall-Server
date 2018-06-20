package com.mall.product.dao.impl;

import com.mall.product.dao.ProductDao;
import com.mall.product.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * 商品信息-服务层实现
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    public HibernateTemplate template;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveProduct(Product product) {
        template.save(product);
    }

}
