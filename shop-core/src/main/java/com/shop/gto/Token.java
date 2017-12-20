package com.shop.gto;

import com.shop.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by TW on 2017/10/27.
 */
@Setter
@Getter
public class Token implements Serializable {

    private String mobile ;
    private String value ;

}
