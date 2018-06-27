package com.mall.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    // 唯一标识 ID
    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="native")
    private int id;

    // 套餐ID
    @Column(name="attr_id")
    private int attrId;

    // 套餐名称
    @Column(name="attr_title")
    private String attrTitle;

    // 商品名称
    @Column(name="goods_name")
    private String goodsName;

    // 商品图片
    private String img;

    // 套餐code
    @Column(name="goods_code")
    private String goodsCode;

    // 商家ID
    @Column(name="merchant_id")
    private String merchantId;

    // 购买数量
    private int count;

//    @ManyToOne
//    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttrId() {
        return attrId;
    }

    public void setAttrId(int attrId) {
        this.attrId = attrId;
    }

    public String getAttrTitle() {
        return attrTitle;
    }

    public void setAttrTitle(String attrTitle) {
        this.attrTitle = attrTitle;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
}
