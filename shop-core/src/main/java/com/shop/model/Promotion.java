package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 17173 on 2017/12/8.
 * 精品主题表
 */
@Setter
@Getter
public class Promotion extends BaseModel implements Serializable {
    //精品活动头像
    private String image;
    //精品活动title
    private String title;
    //精品活动简介
    private String info;
    //精品活动链接
    private String url;

}
