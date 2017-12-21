package com.shop.query;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 17173 on 2017/12/8.
 * 品牌表
 */
@Setter
@Getter
public class BrandDesignerQuery extends BaseModel  {

    private Integer type;
    //品牌名称
    private String name;
    //设计师头像
    private String heading;


}
