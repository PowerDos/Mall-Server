package com.mall.admin.dao.impl;

import com.mall.admin.dao.SecondKillDao;
import com.mall.model.SecondKill;
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
public class SecondKillDaoImpl implements SecondKillDao {
    private HibernateTemplate template;

    @Autowired
    public SecondKillDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<SecondKill> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(SecondKill.class);
        return (List<SecondKill>) template.findByCriteria(criteria);
    }

    @Override
    public SecondKill findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(SecondKill.class);
        criteria.add(Restrictions.eq("id", id));
        List<SecondKill> resultList = (List<SecondKill>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public List<SecondKill> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(SecondKill.class);
        int offset = (page - 1) * pageSize;
        List<SecondKill> resultList = (List<SecondKill>) this.template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    @Transactional()
    public int save(SecondKill secondKill) {
        Serializable result = template.save(secondKill);
        return (Integer) result;
    }

    @Override
    @Transactional()
    public void update(SecondKill secondKill) {
        template.update(secondKill);
    }

    @Override
    @Transactional()
    public void delete(SecondKill secondKill) {
        template.delete(secondKill);
    }

}
