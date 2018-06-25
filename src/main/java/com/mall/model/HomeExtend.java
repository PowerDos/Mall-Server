package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 首页推广
 */
@Entity
@Table(name = "home_extend")
public class HomeExtend {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 推广标题
    private String extendTitle;

    // 推广图片地址
    private String extendImgUrl;

    // 推广所在分组
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "goods_cat_id")
    private GoodsCat goodsCat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtendTitle() {
        return extendTitle;
    }

    public void setExtendTitle(String extendTitle) {
        this.extendTitle = extendTitle;
    }

    public String getExtendImgUrl() {
        return extendImgUrl;
    }

    public void setExtendImgUrl(String extendImgUrl) {
        this.extendImgUrl = extendImgUrl;
    }

    public GoodsCat getGoodsCat() {
        return goodsCat;
    }

    public void setGoodsCat(GoodsCat goodsCat) {
        this.goodsCat = goodsCat;
    }
}
