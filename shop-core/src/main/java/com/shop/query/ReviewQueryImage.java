package com.shop.query;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 17173 on 2017/12/8.
 * 评论表
 */
@Setter
@Getter
public class ReviewQueryImage implements Serializable {


    //晒图
    private String reviewPic1;
    //晒图
    private String reviewPic2;
    //晒图
    private String reviewPic3;


}
