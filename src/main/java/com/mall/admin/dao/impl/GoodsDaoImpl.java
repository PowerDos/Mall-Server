package com.mall.admin.dao.impl;

import com.mall.admin.dao.GoodsDao;
import com.mall.model.Goods;
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
public class GoodsDaoImpl implements GoodsDao {
    private HibernateTemplate template;

    @Autowired
    public GoodsDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<Goods> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByGoodsName(String goodsName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        criteria.add(Restrictions.like("goodsName", "%"+goodsName+"%"));
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        criteria.add(Restrictions.like("goodsName", "%"+goodsName+"%"));
        int offset = (page - 1) * pageSize;
        return (List<Goods>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<Goods> findByCatId(int catId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        GoodsCat goodsCat = new GoodsCat();
        goodsCat.setId(catId);
        criteria.add(Restrictions.eq("goodsCat", goodsCat));
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByCatIdAndPage(int catId, int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        criteria.add(Restrictions.eq("goods_cat_id", catId));
        int offset = (page - 1) * pageSize;
        return (List<Goods>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<Goods> findByPage(int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        int offset = (page - 1) * pageSize;
        List<Goods> resultList = (List<Goods>) this.template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    public Goods findById(int id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        criteria.add(Restrictions.eq("id", id));
        List<Goods> resultList = (List<Goods>) template.findByCriteria(criteria);
        if (resultList.size() == 0) {
            return null;
        }
        return resultList.get(0);
    }

    @Override
    @Transactional()
    public int save(Goods goods) {
        Serializable result = template.save(goods);
        return (Integer) result;
    }

    @Override
    @Transactional()
    public void update(Goods goods) {
        template.update(goods);
    }

    @Override
    @Transactional()
    public void delete(Goods goods) {
        template.delete(goods);
    }

}
