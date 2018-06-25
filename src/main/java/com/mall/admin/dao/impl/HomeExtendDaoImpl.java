package com.mall.admin.dao.impl;

import com.mall.admin.dao.HomeExtendDao;
import com.mall.model.HomeExtend;
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
public class HomeExtendDaoImpl implements HomeExtendDao {
    private HibernateTemplate template;

    @Autowired
    public HomeExtendDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<HomeExtend> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(HomeExtend.class);
        return (List<HomeExtend>) template.findByCriteria(criteria);
    }

    @Override
    public HomeExtend findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(HomeExtend.class);
        criteria.add(Restrictions.eq("id", id));
        List<HomeExtend> resultList = (List<HomeExtend>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public List<HomeExtend> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(HomeExtend.class);
        int offset = (page - 1) * pageSize;
        List<HomeExtend> resultList = (List<HomeExtend>) this.template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    @Transactional()
    public int save(HomeExtend homeExtend) {
        Serializable result = template.save(homeExtend);
        return (Integer) result;
    }

    @Override
    @Transactional()
    public void update(HomeExtend homeExtend) {
        template.update(homeExtend);
    }

    @Override
    @Transactional()
    public void delete(HomeExtend homeExtend) {
        template.delete(homeExtend);
    }

}
