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

    @Transient
    private List<GoodsCat> childrenCats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<GoodsCat> getChildrenCats() {
        return childrenCats;
    }

    public void setChildrenCats(List<GoodsCat> childrenCats) {
        this.childrenCats = childrenCats;
    }
}
