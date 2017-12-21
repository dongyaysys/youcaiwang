package com.shop.query;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 * 评论表
 */
@Setter
@Getter
public class ReviewQuery extends BaseModel  {

    private Integer member;
    //评论内容
    private String content;
    //晒图
    private String reviewPic1;
    //晒图
    private String reviewPic2;
    //晒图
    private String reviewPic3;

    //点赞个数
    private Integer likecount;
    //是否点赞
    private Boolean isLike;
    //用户头像
    private String avatar;
    //昵称
    private String nickname;

    //存储评论图片
//    private List<ReviewQueryImage> list=new ArrayList<>();
    private List<String> imagelist=new ArrayList<>();

}
