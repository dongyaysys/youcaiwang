package com.shop.dao;

import com.shop.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {


	public User findById(User u);

	@Select("select * from dm_user where user_id=#{id} And version=1")
	public User findUserById(@Param("id") Integer id);

	@Select("select name from dm_goods")
	public String[] showRecentBrand();


	@Select("select * from dm_user where mobile=#{mobile} And version=1")
    User findUserByMobile(@Param("mobile") String mobile);

	@Insert("INSERT dm_user (create_date,modify_date,nickname,mobile,version) VALUES(NOW(),NOW(),#{mobile},#{mobile},1)")
	 Integer insertUser(@Param("mobile") String mobile);


}
