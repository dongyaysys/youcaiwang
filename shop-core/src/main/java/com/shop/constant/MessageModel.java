package com.shop.constant;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
@Setter
@Getter
public class MessageModel implements Serializable {
	
	private Integer code=DmConstant.OPS_SUCCESS_CODE;
	private String msg=DmConstant.OPS_SUCCESS_MSG;
	private Object data;

	

}
