package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.OrderDao;
import com.mall.model.Order;
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
public class OrderDaoImpl implements OrderDao {
    public HibernateTemplate template;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    @Transactional
    public int save(Order order) {
        Serializable result = template.save(order);
        Integer integer = (Integer)result;
        return integer;
    }

    @Override
    public List<Order> list(int userId) {
        DetachedCriteria criteria=DetachedCriteria.forClass(Order.class);
        criteria.add(Restrictions.eq("userid", userId));
        List<Order> list = (List<Order>) template.findByCriteria(criteria);
        return list;
    }
}
