package com.mall.admin.dao.impl;

import com.mall.admin.dao.GoodsDao;
import com.mall.model.Goods;
import com.mall.model.GoodsCat;
import com.mall.model.Merchant;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
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
    public List<Goods> findAll(String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByGoodsName(String goodsName, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);
        criteria.add(Restrictions.like("goodsName", "%"+goodsName+"%"));
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByGoodsNameAndPage(String goodsName, int page, int pageSize, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);
        criteria.add(Restrictions.like("goodsName", "%"+goodsName+"%"));
        int offset = (page - 1) * pageSize;
        return (List<Goods>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<Goods> findByMerchantId(int merchantId, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);

        Merchant merchant = new Merchant();
        merchant.setId(merchantId);
        criteria.add(Restrictions.eq("merchant", merchant));
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByMerchantIdAndPage(int merchantId, int page, int pageSize, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);

        Merchant merchant = new Merchant();
        merchant.setId(merchantId);
        criteria.add(Restrictions.eq("merchant", merchant));

        int offset = (page - 1) * pageSize;
        return (List<Goods>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<Goods> findByCatId(int catId, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);

        GoodsCat goodsCat = new GoodsCat();
        goodsCat.setId(catId);
        criteria.add(Restrictions.eq("goodsCat", goodsCat));
        return (List<Goods>) template.findByCriteria(criteria);
    }

    @Override
    public List<Goods> findByCatIdAndPage(int catId, int page, int pageSize, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);

        GoodsCat goodsCat = new GoodsCat();
        goodsCat.setId(catId);
        criteria.add(Restrictions.eq("goodsCat", goodsCat));
        int offset = (page - 1) * pageSize;
        return (List<Goods>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<Goods> findByPage(int page, int pageSize, String orderKeys) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        setOrder(criteria, orderKeys);
        int offset = (page - 1) * pageSize;
        List<Goods> resultList = (List<Goods>) this.template.findByCriteria(criteria, offset, pageSize);
        return resultList;
    }

    @Override
    public int getCount() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);
        criteria.setProjection(Projections.rowCount());
        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByGoodsName(String goodsName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        criteria.add(Restrictions.like("goodsName", "%"+goodsName+"%"));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByMerchantId(int merchantId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        Merchant merchant = new Merchant();
        merchant.setId(merchantId);
        criteria.add(Restrictions.eq("merchant", merchant));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByCatId(int catId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Goods.class);

        GoodsCat goodsCat = new GoodsCat();
        goodsCat.setId(catId);
        criteria.add(Restrictions.eq("goodsCat", goodsCat));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
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

    // 设置排序方式
    private void setOrder(DetachedCriteria criteria, String orderKeys) {
        // 前面带个 - 的就是方向排序
        if (orderKeys.indexOf("-") == -1) {
            criteria.addOrder(Order.asc(orderKeys));
        } else {
            criteria.addOrder(Order.desc(orderKeys.substring(1)));
        }
    }

}
