package com.mall.model;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 商品分类
 */
@Entity
@Table(name = "goods_cat")
public class GoodsCat {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 父 ID
    @ColumnDefault(value = "0")
    private int parentId;

    // 分类名称
    private String catName;

    // 分类下的所有商品
    @OneToMany(mappedBy = "goodsCat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goods> goodses;

}
