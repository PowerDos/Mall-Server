package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.UserDao;
import com.mall.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao{
    public HibernateTemplate template;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public int saveUser(User user) {
        Serializable result = template.save(user);
        Integer integer = (Integer)result;
        return integer;
    }
}
