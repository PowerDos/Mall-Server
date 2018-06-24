package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 商品信息
 *
 * 商品信息是商品的多个键值对关系
 * 如 重量： 30kg, 功能： 防水
 *
 */
@Entity
@Table(name = "goods_detail")
public class GoodsDetail {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 商品详细信息的 Key
    private String detailKey;

    // 商品详细信息的 Value
    private String detailValue;

    // 商品
    @ManyToOne
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailKey() {
        return detailKey;
    }

    public void setDetailKey(String detailKey) {
        this.detailKey = detailKey;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
