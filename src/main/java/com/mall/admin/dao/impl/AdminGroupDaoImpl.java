package com.mall.admin.dao.impl;

import com.mall.admin.dao.AdminGroupDao;
import com.mall.model.AdminGroup;
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
public class AdminGroupDaoImpl implements AdminGroupDao {

    private HibernateTemplate template;

    @Autowired
    public AdminGroupDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<AdminGroup> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminGroup.class);
        return (List<AdminGroup>) template.findByCriteria(criteria);
    }

    @Override
    public AdminGroup findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminGroup.class);
        criteria.add(Restrictions.eq("id", id));
        List<AdminGroup> resultList = (List<AdminGroup>) template.findByCriteria(criteria);

        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public List<AdminGroup> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(AdminGroup.class);
        int offset = (page - 1) * pageSize;
        List<AdminGroup> resultList = (List<AdminGroup>) template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    @Transactional()
    public int save(AdminGroup adminGroup) {
        Serializable result = template.save(adminGroup);
        return (Integer)result;
    }

    @Override
    @Transactional()
    public void update(AdminGroup adminGroup) {
        template.update(adminGroup);
    }

    @Override
    @Transactional()
    public void delete(AdminGroup adminGroup) {
        template.delete(adminGroup);
    }
}
