package com.mall.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    // 商品销售总数
    private int salesNum;

    // 商品所在分类 ID
    @ManyToOne
    @JoinColumn(name = "goods_cat_id",
            foreignKey = @ForeignKey(name = "GOODS_CAT_ID_FK")
    )
    private GoodsCat goodsCat;

    // 商品所属商家
    @ManyToOne
    @JoinColumn(name = "merchant_id",
            foreignKey = @ForeignKey(name = "MERCHANT_ID_FK")
    )
    private Merchant merchant;

    // 商品所在分组（提供给商家自己对商品归类）
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "goods_groups",joinColumns = @JoinColumn(name = "goods_id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<GoodsGroup> goodsGroups = new HashSet<>();

    // 商品套餐（价格在这里面定义）
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<GoodsAttr> goodsAttrs = new HashSet<>();

    // 商品详细配置信息
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<GoodsDetail> goodsDetails = new HashSet<>();

    // 商品评价
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<GoodsComment> goodsComments = new HashSet<>();

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

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public GoodsCat getGoodsCat() {
        return goodsCat;
    }

    public void setGoodsCat(GoodsCat goodsCat) {
        this.goodsCat = goodsCat;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Set<GoodsGroup> getGoodsGroups() {
        return goodsGroups;
    }

    public void setGoodsGroups(Set<GoodsGroup> goodsGroups) {
        this.goodsGroups = goodsGroups;
    }

    public Set<GoodsAttr> getGoodsAttrs() {
        return goodsAttrs;
    }

    public void setGoodsAttrs(Set<GoodsAttr> goodsAttrs) {
        this.goodsAttrs = goodsAttrs;
    }

    public Set<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(Set<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Set<GoodsComment> getGoodsComments() {
        return goodsComments;
    }

    public void setGoodsComments(Set<GoodsComment> goodsComments) {
        this.goodsComments = goodsComments;
    }
}
