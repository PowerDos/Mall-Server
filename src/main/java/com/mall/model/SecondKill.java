package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 首页推广
 */
@Entity
@Table(name = "second_kill")
public class SecondKill {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 秒杀推广图片
    private String skImg;

    // 秒杀价格
    private double skPrice;

    // 秒杀结束时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date endedAt;

    // 该秒杀对应的商品套餐
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "goods_attr_id")
    private GoodsAttr goodsAttr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkImg() {
        return skImg;
    }

    public void setSkImg(String skImg) {
        this.skImg = skImg;
    }

    public double getSkPrice() {
        return skPrice;
    }

    public void setSkPrice(int skPrice) {
        this.skPrice = skPrice;
    }

    public GoodsAttr getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(GoodsAttr goodsAttr) {
        this.goodsAttr = goodsAttr;
    }
}
