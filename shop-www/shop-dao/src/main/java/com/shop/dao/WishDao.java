package com.shop.dao;/**
 * Created by 17173 on 2017/12/21.
 */

import com.shop.query.BrandDesignerQuery;
import com.shop.query.GoodsQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author DY
 * @create 2017-12-21 14:57
 **/
public interface WishDao {

    @Select("SELECT id,image,create_date,NAME,caption,is_custom,price,sales,create_date," +
            "modify_date FROM dm_goods WHERE version=1 AND id=ANY(select goods from dm_collection" +
            " where user_id=#{userId}) ORDER BY create_date DESC ")
    List<GoodsQuery> findWishGoods(@Param("userId") Integer userId);


    List<BrandDesignerQuery> findBrandsAndDesigner(@Param("userId") Integer userId);
}
