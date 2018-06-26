package com.mall.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 商品评论
 */
@Entity
@Table(name = "goods_comment")
public class GoodsComment {

    /**
     * TODO
     * 1.增加评论
     * POST：
     *  {
     *      commemtContent: '评论信息',
     *      commentLevel: 4,
     *      tags: "好用,不错,货美价廉",
     *      username: "Gavin",
     *      userid: 1,
     *      goodsId: 1,
     *      attrTitle: "4.7英寸-深邃蓝",
     *      attrId: 102,
     *      orderId: 2
     *  }
     *
     * 注意：goodsId 是外键，连接商品
     *
     * 2. 获取评论
     * 方法 goodsService.findById() 获取单个商品时，需要返回字段 comment
     * 具体展示内容如下:
     *
     * comment: {
     *  commentNum: 16, // 总评论数
     *  remarksNumDetail: [ 2, 2, 2, 3, 1 ] // 分别是5个评论等级的评论数(字段：commentLevel)， [ 好评， 满意， 一般, 差, 非常差 ]
     *  detail: [ // 评论详细内容
     *      {
     *          username: "Gavin", // 用户名
     *          commentLevel: 5, // 等级
     *          commemtContent: "颜色很好看，质量也不错！", // 评论
     *          attrTitle: "4.7英寸-深邃蓝",
     *          tags: "好用,不错,货美价廉",
     *          createAt: "2018-05-15 09:20"
     *       },
     *       {
     *          username: "Gavin", // 用户名
     *          commentLevel: 5, // 等级
     *          commemtContent: "颜色很好看，质量也不错！", // 评论
     *          attrTitle: "4.7英寸-深邃蓝",
     *          tags: "好用,不错,货美价廉",
     *          createAt: "2018-05-15 09:20"
     *       }
     *  ]
     * }
     */

    // 唯一标识 ID
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;

    // 评价内容
    private String commentContent;

    // 评价等级：星星数量
    private int commentLevel;

    // 评论标签 例:"好用,不错,货美价廉" 前台写死规定几个标签供选择
    private String tags;

    // 用户名
    private String username;

    // 用户id
    private int userid;

    // 商品Id # 外键
    private int goodsId;

    // 套餐描述
    private String attrTitle;

    // 评论时间
    private Date createAt;

    // 订单号
    private String orderId;

//    @ManyToOne
//    private Goods goods;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getAttrTitle() {
        return attrTitle;
    }

    public void setAttrTitle(String attrTitle) {
        this.attrTitle = attrTitle;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
