package com.mall.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// 购物车
@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="native")
    private int id; // 购物车id
    // 商品图片
    private String img;
    // 商品ID
    @Column(name="goods_id")
    private int goodsId;
    @Column(name="user_id")
    private int userId;
    // 商户ID
    @Column(name="merchant_id")
    private int merchantId;
    // 套餐ID
    @Column(name="attr_id")
    private int attrId;
    // 商品价格
    private double price;
    // 商品个数
    private int count;
    // 商品描述
    private String title;
    // 套餐描述
    @Column(name="attr_title")
    private String attrTitle;
    // 商品code
    @Column(name="attr_code")
    private String goodsCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
