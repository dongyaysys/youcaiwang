package com.shop.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.constant.DmConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * base表
 */
@Setter
@Getter
public class BaseQuery implements Serializable {

    private Integer page= DmConstant.PAGE;
    private Integer prows= DmConstant.ROWS;

}
