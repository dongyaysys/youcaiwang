package com.shop.util;



public class MobileUtil {
	/**
	 * 手机号码前缀
	 *  "auth_code_"
	 */
	private final static String AUTH_CODE_PREFIX = "";
	private final static String AUTH_CODE_SUFF = "";

	public static String returnNewMobile(String mobile){

		mobile=AUTH_CODE_PREFIX+mobile+AUTH_CODE_SUFF;
		return mobile;
	}

	
	
}
