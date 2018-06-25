package com.mall.admin.service.impl;

import com.mall.admin.dao.GoodsCatDao;
import com.mall.admin.service.GoodsCatService;
import com.mall.model.GoodsCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCatServiceImpl implements GoodsCatService {

    @Autowired
    private GoodsCatDao goodsCatDao;

    @Override
    public List<GoodsCat> findAll() {
        List<GoodsCat> goodsCats = goodsCatDao.findByParentId(0);
        if (goodsCats == null) {
            return null;
        }

        setChildrenCats(goodsCats);
        return goodsCats;
    }

    @Override
    public GoodsCat findById(int id) {
        GoodsCat goodsCat = goodsCatDao.findById(id);
        return goodsCat;
    }

    @Override
    public int save(GoodsCat goodsCat) {
        int status = goodsCatDao.save(goodsCat);
        return status;
    }

    @Override
    public void update(GoodsCat goodsCat) {
        goodsCatDao.update(goodsCat);
    }

    @Override
    public void delete(GoodsCat goodsCat) {
        goodsCatDao.delete(goodsCat);
    }

    // 格式化结果，将所有子分类拼接到父分类中
    private void setChildrenCats(List<GoodsCat> goodsCats) {
        System.out.println(goodsCats);
        for (int i = 0; i < goodsCats.size(); i++) {
            GoodsCat goodsCat = goodsCats.get(i);

            List<GoodsCat> childrenCats = goodsCatDao.findByParentId(
                    goodsCat.getId());
            goodsCat.setChildrenCats(childrenCats);
        }
    }
}
