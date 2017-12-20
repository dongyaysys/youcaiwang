package com.shop.gto;

import com.shop.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by TW on 2017/10/27.
 */
@Setter
@Getter
public class GoodsDto extends BaseDto {

    private String keyword ;
    private Double startPrice;
    private Double endPrice;
    private Integer isShow;
    private Integer goods;
    private Integer scene;
    private Integer category;
    private Integer season;
    private Integer gender;
    private Integer size;
    private Integer material;

}
