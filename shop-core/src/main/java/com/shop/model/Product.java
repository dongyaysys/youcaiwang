package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by 17173 on 2017/12/7.
 */
@Setter
@Getter
public class Product extends BaseModel implements Serializable  {

    //货品id
    private Integer goodsId;
    //剩余库存
    private Integer allocatedStock;
    //成本价
    private BigDecimal cost;

    //是否为默认商品
    private Boolean isDefault;
    //市场价
    private BigDecimal marketPrice;
    //出售价
    private BigDecimal price;
    //商品sn码
    private String sn;
    //商品尺寸
    private String size;
    //商品面料
    private String material;
    //商品总库存
    private Integer stock;
    //商品介绍
    private String introduction;
    //详情分类
    private Integer category;
    //品牌/设计师
    private String bd;
    //定制其他
    private String other;

}
