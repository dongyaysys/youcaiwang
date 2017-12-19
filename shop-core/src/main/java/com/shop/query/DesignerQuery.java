package com.shop.query;

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
public class DesignerQuery  implements Serializable {
    private Integer id;
    //设计师名称
    private String name;
    //设计师头像
    private String heading;
    //设计师图片
    private String image;
    //设计师详情页图片
    private String imageDetail;

    private String recentImage;
    //精选设计师字段一
    private String designserTop;
    //精选设计师字段二
    private String designserCentre;
    //精选设计师字段三
    private String designserBottom;

}
