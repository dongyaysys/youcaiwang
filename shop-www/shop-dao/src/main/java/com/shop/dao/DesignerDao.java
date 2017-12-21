package com.shop.dao;

import com.shop.model.Designer;
import com.shop.query.DesignerQuery;
import com.shop.query.GoodsQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 */

public interface DesignerDao {

    @Select("select id,create_date,modify_date,image,name,designser_top,designser_centre," +
            "designser_bottom  from dm_designer where is_selection=1 and version=1 limit 5")
    public List<DesignerQuery> showHotDesignders();

    @Select("SELECT id,create_date,modify_date,recent_image FROM dm_designer where version=1 ORDER BY create_date desc limit 5")
    public List<DesignerQuery> showRecentDesignders();

    public List<DesignerQuery> showPopularDesignders();

    @Select("select id,create_date,modify_date,name,image_detail,introduction from dm_designer where id=#{id} and version=1")
    public Designer showDesignerDetail(@Param("id") Integer id);

    @Select("select id,create_date,modify_date,heading,name,fristPinyin(name) as fristPinyin from dm_designer where version=1 ORDER BY fristPinyin")
    List<DesignerQuery> queryBrandDesignersByName();

}
