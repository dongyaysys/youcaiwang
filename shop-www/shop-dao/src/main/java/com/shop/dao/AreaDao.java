package com.shop.dao;/**
 * Created by 17173 on 2017/12/21.
 */

import com.shop.model.Receiver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author DY
 * @create 2017-12-21 18:05
 **/
public interface AreaDao {


    @Insert("INSERT dm_receiver (member,receiver_people,mobile,area,address,create_date,modify_date,version,is_default)" +
            " VALUES(#{userId},#{people},#{mobile},#{area},#{address},NOW(),NOW(),1,0)")
    Integer insertArea(@Param("userId") Integer userId,@Param("people") String people,
                       @Param("mobile") String mobile,@Param("area") String area,@Param("address") String address);


    @Insert("INSERT dm_receiver (member,receiver_people,mobile,area,address,create_date,modify_date,is_default,version)" +
            " VALUES(#{userId},#{people},#{mobile},#{area},#{address},NOW(),NOW(),1,1)")
    Integer insertAreaDefaule(@Param("userId") Integer userId,@Param("people") String people,
                       @Param("mobile") String mobile,@Param("area") String area,@Param("address") String address);

    @Update("UPDATE dm_receiver SET modify_date=NOW(),receiver_people = #{people},mobile = #{mobile}," +
            "area = #{area},address = #{address} WHERE id = #{areaId}")
    Integer updateArea(@Param("people") String people,
                       @Param("mobile") String mobile,@Param("area") String area,
                       @Param("address") String address,@Param("areaId") Integer areaId);

    @Select("SELECT id,create_date,modify_date,address,version,mobile,area,is_default," +
            "member,receiver_people FROM dm_receiver WHERE version=1 AND member=#{userId}")
    List<Receiver> queryReceviewByUserId(@Param("userId") Integer userId);

    @Select("select * from dm_receiver where member=#{userId}")
    Integer queryAreaExist(@Param("userId") Integer userId);


    @Update("UPDATE dm_receiver SET modify_date=NOW(),is_default = 0 WHERE member = #{userId} AND is_default=1")
    Integer deleteDefaultCode(@Param("userId") Integer userId);

    @Update("UPDATE dm_receiver SET modify_date=NOW(),is_default = 1 WHERE member = #{userId} AND id=#{receiverId}")
    Integer updateDefaultCode(@Param("userId") Integer userId,@Param("receiverId") Integer receiverId);



}
