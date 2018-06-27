package com.mall.admin.dao.impl;

import com.mall.admin.dao.MerchantDao;
import com.mall.model.Merchant;
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
public class MerchantDaoImpl implements MerchantDao {
    private HibernateTemplate template;

    @Autowired
    public MerchantDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<Merchant> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Merchant.class);
        return (List<Merchant>) template.findByCriteria(criteria);
    }

    @Override
    public Merchant findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Merchant.class);
        criteria.add(Restrictions.eq("id", id));
        List<Merchant> resultList = (List<Merchant>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    public List<Merchant> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Merchant.class);
        int offset = (page - 1) * pageSize;
        List<Merchant> resultList = (List<Merchant>) this.template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    public List<Merchant> getMerchantByMerchantName(String merchantName) {
        DetachedCriteria criteria=DetachedCriteria.forClass(Merchant.class);
        criteria.add(Restrictions.eq("merchantName", merchantName));
        List<Merchant> list = (List<Merchant>) template.findByCriteria(criteria, 0, 1);
        return list;
    }

    @Override
    @Transactional()
    public int save(Merchant merchant) {
        Serializable result = template.save(merchant);
        return (Integer) result;
    }

    @Override
    @Transactional()
    public void update(Merchant merchant) {
        template.update(merchant);
    }

    @Override
    @Transactional()
    public void delete(Merchant merchant) {
        template.delete(merchant);
    }

}
