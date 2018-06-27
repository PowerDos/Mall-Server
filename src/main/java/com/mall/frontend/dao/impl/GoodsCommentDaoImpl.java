package com.mall.frontend.dao.impl;

import com.mall.frontend.dao.GoodsCommentDao;
import com.mall.model.GoodsComment;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class GoodsCommentDaoImpl implements GoodsCommentDao {

    public HibernateTemplate template;

    @Autowired
    public GoodsCommentDaoImpl(SessionFactory sessionFactory) {
        template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public List<GoodsComment> findByGoodsId(int goodsId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        return (List<GoodsComment>) template.findByCriteria(criteria);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndPage(int goodsId, int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        int offset = (page - 1) * pageSize;
        return (List<GoodsComment>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndCommentLevel(int goodsId, int commentLevel) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        criteria.add(Restrictions.eq("commentLevel", commentLevel));
        return (List<GoodsComment>) template.findByCriteria(criteria);
    }

    @Override
    public List<GoodsComment> findByGoodsIdAndCommentLevelAndPage(int goodsId, int commentLevel, int page, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        criteria.add(Restrictions.eq("commentLevel", commentLevel));
        int offset = (page - 1) * pageSize;
        return (List<GoodsComment>) template.findByCriteria(criteria, offset, pageSize);
    }

    @Override
    public int getCount() {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);
        criteria.setProjection(Projections.rowCount());
        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByGoodsId(int goodsId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByCommentLevel(int commentLevel) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("commentLevel", commentLevel));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    public int getCountByGoodsIdAndCommentLevel(int goodsId, int commentLevel) {
        DetachedCriteria criteria = DetachedCriteria.forClass(GoodsComment.class);

        criteria.add(Restrictions.eq("goodsid", goodsId));
        criteria.add(Restrictions.eq("commentLevel", commentLevel));
        criteria.setProjection(Projections.rowCount());

        Object obj  = template.findByCriteria(criteria).get(0);
        Long longObj = (Long) obj;
        int count = longObj.intValue();
        return count;
    }

    @Override
    @Transactional
    public int save(GoodsComment goodsComment) {
        Serializable result = template.save(goodsComment);
        Integer integer = (Integer)result;
        return integer;
    }

}
