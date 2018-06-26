package com.mall.admin.dao.impl;

import com.mall.admin.dao.AdminUserDao;
import com.mall.model.AdminUser;
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
public class AdminUserDaoImpl implements AdminUserDao {

    private HibernateTemplate template;

    @Autowired
    public AdminUserDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<AdminUser> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminUser.class);
        return (List<AdminUser>) template.findByCriteria(criteria);
    }

    @Override
    public AdminUser findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminUser.class);
        criteria.add(Restrictions.eq("id", id));
        List<AdminUser> resultList = (List<AdminUser>) template.findByCriteria(criteria);

        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public List<AdminUser> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminUser.class);
        int offset = (page - 1) * pageSize;
        List<AdminUser> resultList = (List<AdminUser>) template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    @Transactional()
    public int save(AdminUser adminUser) {
        Serializable result = template.save(adminUser);
        return (Integer)result;
    }

    @Override
    @Transactional()
    public void update(AdminUser adminUser) {
        template.update(adminUser);
    }

    @Override
    @Transactional()
    public void delete(AdminUser adminUser) {
        template.delete(adminUser);
    }
}
