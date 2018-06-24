package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 商品
 */
@Entity
@Table(name = "goods")
public class Goods {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 商品名称
    private String goodsName;

    // 商品图片多张使用 `,` 分割，限制最多五张
    private String goodsImgs;

    // 商品描述（只能使用图片，规则和商品图片相同）
    private String goodsDesc;

    // 商品所在分类 ID
    @ManyToOne
    private GoodsCat goodsCat;

    // 商品所在分组（提供给商家自己对商品归类）
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<GoodsGroup> goodsGroups;

    // 商品套餐（价格在这里面定义）
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsAttr> goodsAttrs;

    // 商品详细配置信息
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsDetail> goodsDetails;

    // 商品评价
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsComment> goodsComments;

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

    public String getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(String goodsImgs) {
        this.goodsImgs = goodsImgs;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public GoodsCat getGoodsCat() {
        return goodsCat;
    }

    public void setGoodsCat(GoodsCat goodsCat) {
        this.goodsCat = goodsCat;
    }

    public List<GoodsGroup> getGoodsGroups() {
        return goodsGroups;
    }

    public void setGoodsGroups(List<GoodsGroup> goodsGroups) {
        this.goodsGroups = goodsGroups;
    }

    public List<GoodsAttr> getGoodsAttrs() {
        return goodsAttrs;
    }

    public void setGoodsAttrs(List<GoodsAttr> goodsAttrs) {
        this.goodsAttrs = goodsAttrs;
    }

    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public List<GoodsComment> getGoodsComments() {
        return goodsComments;
    }

    public void setGoodsComments(List<GoodsComment> goodsComments) {
        this.goodsComments = goodsComments;
    }
}
