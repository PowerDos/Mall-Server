package com.mall.example.dao.impl;

import com.mall.example.dao.UserDao;
import com.mall.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * 商品信息-服务层实现
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    public HibernateTemplate template;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveUser(User user) {
        template.save(user);
    }

}
