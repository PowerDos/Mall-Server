# Mall-Server
> 基于SSH的商城后台API应用

## 技术栈
- Struts 2.5.16
- Hibernate 5.0.7
- Spring 5.1.7

## 开发环境
> IDEA 2017

## 数据库
> Mysql


## Maven

    使用 Maven 来整合 SSH，详细配置见配置文件 `pom.xml`

    使用 Spring 整合了 Struts2 和 Hibernate ，免去了冗余的 Hibernate 配置文件 `hibernate.cfg.xml` 。


## Build

    使用 Idea 打开项目后，打开项目工程配置，标注 Spring 和 Struts2 的配置文件，然后配置 Tomcat 便可运行（记得配置 Deployment ）

## TODO 

    1. 接入商品数据（八个商品一个商家，一页总共 48）
        1. 手机壳 16个
        2. 零食
        3. 电脑
    
    2. 爬取京东数据
        
    3. 前端接口对接
        1. 商家注册
        2. 商家登陆
        
    4. 修复首页推广, 秒杀接口更新删除 BUG

    5. 修复上传接口 BUG
    
    6. 修改秒杀接口返回的数据，封装好 Goods 返回，包含秒杀价格的 GoodsAttr （添加 Goods 接口：根据 GoodsAttrId 来查找商品）

