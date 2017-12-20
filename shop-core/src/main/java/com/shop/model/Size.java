package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 * 品牌表
 */
@Setter
@Getter
public class Size  implements Serializable {

    //商品尺寸id
    private Integer id;

    //商品尺寸名称
    private String size;
    
    //面料
    private List<Material> materialList;

    ;


}
