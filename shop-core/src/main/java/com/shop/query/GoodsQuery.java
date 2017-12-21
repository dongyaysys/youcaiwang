package com.shop.query;
import com.shop.base.BaseModel;
import com.shop.base.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * base表
 */
@Setter
@Getter
public class GoodsQuery extends BaseModel {

    private String name;
    //副标题
    private String caption;

    private BigDecimal price;
    //销售数量
    private BigDecimal sales;
    //货品介绍
    private String introduction;
    //图片
    private String image;
    //是否可定制 0代表不可以,1代表可以
    private Boolean isCustom;

    //是否上架 1代表上架 0代表下架
    private Boolean isMarkettable;
    //商品所属类别
    private Integer productCategory;



}
