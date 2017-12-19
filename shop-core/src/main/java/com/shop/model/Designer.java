package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 17173 on 2017/12/8.
 * 设计师表
 */
@Setter
@Getter
public class Designer extends BaseModel implements Serializable {

    //设计师名称
    private String name;
    //设计师头像
    private String heading;
    //设计师秀场图片
    private String image;
    //设计师详情页图片
    private String imageDetail;
    //设计师图片用于最新入驻展示
    private String recentImage;
    //设计师介绍
    private String introduction;
    //精选设计师字段一
    private String designserTop;
    //精选设计师字段二
    private String designserCentre;
    //精选设计师字段三
    private String designserBottom;
    //是否被选中
    private Integer isSelection;

}
