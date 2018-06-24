package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 商品评论
 */
@Entity
@Table(name = "goods_comment")
public class GoodsComment {

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 评价内容
    private String commentContent;

    // 评价等级：星星数量
    private int commentLevel;

    @ManyToOne
    private Goods goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(int commentLevel) {
        this.commentLevel = commentLevel;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
