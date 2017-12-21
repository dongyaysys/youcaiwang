package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 * 货品表
 */
@Setter
@Getter
public class Goods extends BaseModel {
   /* //所属品牌
    private Integer brands;
    //所属设计师
    private Integer designers;*/
    //货品名称
    private String name;
    //产品标题
    private String productInfo;
    //副标题
    private String caption;
    //男装女装 1男2女
    private Integer gender;
    //货品类型所属类别 1-品牌2-设计师
    private Integer type;
    //货品价格
    private BigDecimal price;
    //货品单位
    private String unit;
    //货品重量
    private Integer weight;
    //是否上架 1代表上架 0代表下架
    private Boolean isMarkettable;
    //货品是否置顶
    private Boolean top;
    //货品介绍
    private String introduction;

    private String productIntroduction;
    //是否需要物流 0代表不需要 1代表需要
    private Boolean isDelivery;
    //备注
    private String memo;
    //页面标题
    private String seoTitle;
    //页面关键字
    private String seoKeywords;
    //页面描述
    private String seoDescription;
    //积分
    private Float score;
    //总积分
    private Float totalScore;
    //点击数
    private BigDecimal hit;
    //销售数量
    private BigDecimal sales;
    //图片
    private String image;
    //图片
    private String productImageTop;
    //图片
    private String productImageBottom;
    //材质详情
    private String materialDetail;
    //关键字
    private String keywords;
    //是否可定制 0代表不可以,1代表可以
    private Boolean isCustom;
    //场景分类 1.休闲 2.晚宴 3.面试 4.会客 5.礼服 6.秀场 7.化妆会 8.相亲
    private Integer productScene;
    //季节分类: 1.春 2.夏 3.秋 4.冬
    private Integer productSeason;
    //所属品类
    private String productCategory;

    //商品尺寸
    private List<Size> size;


    //商品面料
   private List<Material> material;





}
