package com.shop.query;

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
public class BrandQuery extends BaseModel  {

    private Integer id;
    //品牌名称
    private String name;
    //设计师头像
    private String heading;
    //设计师图片
    private String image;
    //品牌详情页图片
    private String imageDetail;

    private String recentImage;
    //精选品牌字段1
    private String brandTop;
    //精选品牌字段2
    private String brandCentre;
    //精选品牌字段3
    private String brandBottom;

}
