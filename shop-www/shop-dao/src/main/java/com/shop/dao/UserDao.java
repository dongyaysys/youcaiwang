package com.shop.dao;

import com.shop.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {


	public User findById(User u);

	@Select("select * from dm_user where user_id=#{id} And version=1")
	public User findUserById(@Param("id") Integer id);

	@Select("select name from dm_goods")
	public String[] showRecentBrand();


}
