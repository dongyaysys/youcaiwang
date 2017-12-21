package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 17173 on 2017/12/8.
 * 收货地址
 */
@Setter
@Getter
public class Receiver extends BaseModel  {


    //所属用户
    private Integer member;
    //是否为默认地址
    private Boolean isDefault;

    //收货地区
    private String area;
    //收货详细地址
    private String address;
    //昵称
    private String mobile;
    //收货人
    private String reviewPeople;


}
