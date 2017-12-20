package com.shop.constant;

import java.util.Map;

/**
 * 
 *@author lp
 *  常量类
 */
public class DmConstant {
	
	public static final Integer OPS_SUCCESS_CODE=200;
	public static final String OPS_SUCCESS_MSG="操作成功";

	public static final Integer OPS_SUCCESS_CODE_NULL=100;

	public static Integer opscode(Map map){

		if(map.size()==0){
			return OPS_SUCCESS_CODE_NULL;
		}
		else {
			return OPS_SUCCESS_CODE;
		}
	}

	public static final Integer OPS_FAILED_CODE=300;
	public static final String  OPS_FAILED_MSG="操作失败";
	
	public static final String   USER_NOT_LOGIN_MSG="用户未登录";// 用户未登录msg
	public static final Integer  USER_NOT_LOGIN_CODE=305;// 用户未登录code
	
	public static final Integer PAGE=1;
	public static final Integer ROWS=10;
	
	
}
