package com.mall.admin.dao.impl;

import com.mall.admin.dao.GoodsCatDao;
import com.mall.model.GoodsCat;
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
public class GoodsCatDaoImpl implements GoodsCatDao {
    private HibernateTemplate template;

    @Autowired
    public GoodsCatDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<GoodsCat> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsCat.class);
        return (List<GoodsCat>) template.findByCriteria(criteria);
    }

    @Override
    public List<GoodsCat> findByParentId(int parentId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsCat.class);
        criteria.add(Restrictions.eq("parentId", parentId));
        List<GoodsCat> resultList = (List<GoodsCat>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList;
    }

    @Override
    public GoodsCat findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsCat.class);
        criteria.add(Restrictions.eq("id", id));
        List<GoodsCat> resultList = (List<GoodsCat>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    @Override
    @Transactional()
    public int save(GoodsCat goodsCat) {
        Serializable result = template.save(goodsCat);
        return (Integer) result;
    }

    @Override
    @Transactional()
    public void update(GoodsCat goodsCat) {
        template.update(goodsCat);
    }

    @Override
    @Transactional()
    public void delete(GoodsCat goodsCat) {
        template.delete(goodsCat);
    }

}
