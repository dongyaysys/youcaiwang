package com.shop.util;


import com.shop.constant.JedisConstant;
import com.shop.gto.Token;
import redis.clients.jedis.Jedis;

public class IsLogin {
	
	public static Boolean  isLogin(Token token){
		String mobile=token.getMobile();
		String value=token.getValue();
		AssertUtil.isNotEmpty(mobile,"异常访问");
		AssertUtil.isNotEmpty(value,"异常访问");
		//构建token
		Jedis jedis=new Jedis(JedisConstant.JEDISHOST, JedisConstant.JEDISPORT);
		jedis.auth(JedisConstant.POSSWORD);
		String tokenValue=jedis.get(mobile);

		Boolean isLogin=null;
		if(null==tokenValue||!tokenValue.equals(value)){

			isLogin=false;
		}
		else if(tokenValue.equals(value)){
			jedis.expire(mobile,300);
			isLogin=true;
		}

		return  isLogin;

	}
	
	
}
