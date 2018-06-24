package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 商品套餐
 *
 */
@Entity
@Table(name = "goods_attr")
public class GoodsAttr {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 该配置信息
    private String attrTitle;

    // 该配置商品编号（每一个属性都有一个独特的商品编号）
    private String goodsCode;

    // 该配置商品价格
    private int attrPrice;

    // 该配置商品是否已上架
    private Boolean onSale;

    @ManyToOne
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttrTitle() {
        return attrTitle;
    }

    public void setAttrTitle(String attrTitle) {
        this.attrTitle = attrTitle;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getAttrPrice() {
        return attrPrice;
    }

    public void setAttrPrice(int attrPrice) {
        this.attrPrice = attrPrice;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
