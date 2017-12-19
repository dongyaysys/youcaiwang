package com.shop.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by TW on 2017/10/24.
 */
@Getter
@Setter
public class ResultInfo {
    private Integer resultCode;
    private String resultMessage;
    private Object result;

}
