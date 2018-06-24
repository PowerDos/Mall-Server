package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 商品分组
 *
 * 商品分组提供给商家自己归类商品
 *
 */
@Entity
@Table(name = "goods_group")
public class GoodsGroup {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    private String goodsName;

    @ManyToMany(mappedBy = "goodsGroups", fetch = FetchType.EAGER)
    private List<Goods> goodses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }
}
