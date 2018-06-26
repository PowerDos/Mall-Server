package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.AddressDao;
import com.mall.model.Address;
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
public class AddressDaoImpl implements AddressDao {

    public HibernateTemplate template;

    @Autowired
    public AddressDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    @Transactional
    public int save(Address address) {
        Serializable result = template.save(address);
        Integer integer = (Integer)result;
        return integer;
    }

    @Override
    public List<Address> list(int userid) {
        DetachedCriteria criteria= DetachedCriteria.forClass(Address.class);
        criteria.add(Restrictions.eq("userid", userid));
        List<Address> list = (List<Address>) template.findByCriteria(criteria);
        return list;
    }

    @Override
    @Transactional()
    public void delete(Address address) {
        template.delete(address);
    }

    @Override
    @Transactional()
    public void update(Address address) {
        template.update(address);
    }
}
