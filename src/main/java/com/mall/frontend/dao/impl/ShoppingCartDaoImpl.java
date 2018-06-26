package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.ShoppingCartDao;
import com.mall.model.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    public HibernateTemplate template;

    @Autowired
    public ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    @Transactional
    public int saveShoppingCart(ShoppingCart shoppingCart) {
        Serializable result = template.save(shoppingCart);
        Integer integer = (Integer)result;
        return integer;
    }

    @Override
    public List<ShoppingCart> getShoppingCartByUserId(int userid) {
        DetachedCriteria criteria=DetachedCriteria.forClass(ShoppingCart.class);
        criteria.add(Restrictions.eq("userId", userid));
        List<ShoppingCart> list = (List<ShoppingCart>) template.findByCriteria(criteria);
        return list;
    }
}
