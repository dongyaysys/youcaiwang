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
public class DesignerPromotion  extends BaseModel implements Serializable {

    private String heading;
    private String title;
    private String info;
    private String url;

}
