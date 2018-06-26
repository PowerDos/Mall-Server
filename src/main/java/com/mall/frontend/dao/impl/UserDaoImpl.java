package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.UserDao;
import com.mall.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao{
    public HibernateTemplate template;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    @Transactional()
    public int saveUser(User user) {
        Serializable result = template.save(user);
        Integer integer = (Integer)result;
        return integer;
    }

    @Override
    public Set<User> getUserByPhone(String phone) {
        DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("phone", phone));
        Set<User> list = (Set<User>) template.findByCriteria(criteria, 0, 1);
        return list;
    }
}
