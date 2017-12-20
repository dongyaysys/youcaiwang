package com.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 17173 on 2017/12/8.
 * 品牌表
 */
@Setter
@Getter
public class Material implements Serializable {

    //商品尺寸id
    private Integer id;

    //商品尺寸名称
    private String material;

    //商品库存
    private Integer stock;


}
