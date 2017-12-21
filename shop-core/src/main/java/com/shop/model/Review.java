package com.shop.model;

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
public class Review extends BaseModel  {

    //评论商品
    private Integer goods;
    //评论用户
    private Integer member;
    //评论内容
    private String content;
    //晒图
    private String reviewPic1;
    //晒图
    private String reviewPic2;
    //晒图
    private String reviewPic3;
    //是否展示 1展示  0不展示
    private Integer isShow;
    //点赞个数
    private Integer likecount;
    //是否点赞
    private Boolean isLike;

    //用户头像
    private String avatar;
    //昵称
    private String nickname;

}
