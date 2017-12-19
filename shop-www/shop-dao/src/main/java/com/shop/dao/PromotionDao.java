package com.shop.dao;

import com.shop.model.Brand;
import com.shop.model.Promotion;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface PromotionDao {

    @Select("select id,title,create_date,modify_date,image,info,url from dm_promotion where version=1")
    public List<Promotion> showPromotion();
}
