package com.shop.dao;

import com.shop.model.Brand;
import com.shop.query.BrandQuery;
import com.shop.query.DesignerQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface BrandDao {

    @Select("select id,create_date,modify_date,name,image,brand_top,brand_centre,brand_bottom from dm_brand where is_selection=1 and version=1")
    public List<BrandQuery> showHotBrands();

    @Select("SELECT id,create_date,modify_date,recent_image FROM dm_brand where version=1 ORDER BY create_date desc limit 5")
    public List<BrandQuery> showRecentBrands();

    public List<BrandQuery> showPopularBrand();

    @Select("select id,name,create_date,modify_date,image_detail,introduction from dm_brand where id=#{id} and version=1")
    public Brand showBrandDetail(@Param("id") Integer id);


    @Select("select id,create_date,modify_date,heading,name,fristPinyin(name) as fristPinyin from dm_brand where version=1 ORDER BY fristPinyin")
    List<BrandQuery> queryBrandDesignersByName();


}
