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
public class Brand extends BaseModel implements Serializable {
    //品牌名称
    private String name;
    //品牌头像
    private String heading;
    //品牌图片
    private String image;
    //品牌详情页图片
    private String imageDetail;
    //品牌图片用于最新入驻品牌展示
    private String recentImage;

    //品牌介绍
    private String introduction;

    //精选品牌字段1
    private String brandTop;
    //精选品牌字段2
    private String brandCentre;
    //精选品牌字段3
    private String brandBottom;
    //品牌是否被选中  1代表选中 0代表未选
    private Integer isSelection;

}
