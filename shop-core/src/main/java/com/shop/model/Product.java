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
    private Integer goods;
    //出售价
    private BigDecimal price;
    //商品尺寸
    private Integer size;
    //商品面料
    private Integer material;
    //商品总库存
    private Integer stock;

}
