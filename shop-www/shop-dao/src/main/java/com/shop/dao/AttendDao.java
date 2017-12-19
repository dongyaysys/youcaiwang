package com.shop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface AttendDao {



    @Select("select * from dm_attend where user_id=#{userId} AND attend=#{attend} AND type=#{type}")
    Integer findIsAttendById(@Param(value = "userId") Integer userId,@Param(value = "attend") Integer attend,@Param(value = "type") Integer type);

    @Insert("INSERT dm_attend (user_id,attend,type,create_date,modify_date) VALUES(#{userId},#{attend},#{type},NOW(),NOW())")
    Integer insertAttend(@Param(value = "userId") Integer userId,@Param(value = "attend") Integer attend,@Param(value = "type") Integer type);

    @Select("select * from dm_collection where user_id=#{userId} AND goods=#{goodsId}")
    Integer findIsCollectionById(@Param(value = "userId")Integer userId,@Param(value = "goodsId") Integer goodsId);

    @Insert("INSERT dm_collection (user_id,goods,create_date,modify_date) VALUES(#{userId},#{goodsId},NOW(),NOW())")
    Integer insertCollection(@Param(value = "userId")Integer userId,@Param(value = "goodsId") Integer goodsId);

    @Delete("DELETE FROM dm_attend WHERE user_id=#{userId} and  attend=#{attend} and type=#{type}")
    Integer deleteAttend(@Param(value = "userId") Integer userId,@Param(value = "attend") Integer attend,@Param(value = "type") Integer type);

    @Delete("DELETE FROM dm_collection WHERE user_id=#{userId} and  goods=#{goodsId}")
    Integer deleteCollection(@Param(value = "userId")Integer userId,@Param(value = "goodsId") Integer goodsId);
}
