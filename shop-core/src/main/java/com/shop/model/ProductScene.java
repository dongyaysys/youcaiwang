package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 17173 on 2017/12/8.
 * 品牌表
 */
@Setter
@Getter
public class ProductScene  implements Serializable {

    private Integer id;
    //分类图片
    private String image;
    //按男女装分类
    private String productScene;



}