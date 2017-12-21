package com.shop.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.gto.GoodsDto;
import com.shop.model.*;
import com.shop.query.GoodsQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface GoodsDao {

    @Select("select id,create_date,modify_date,image,name,caption,is_custom,price,sales from dm_goods where version=1 ")
    public List<GoodsQuery> queryGoods();


    @Select("select id,image,product_scene from dm_goods_scene where gender=#{gender} ")
    public List<ProductScene> querySceneByGender(@Param("gender") Integer gender);


    @Select("select id, category_name from dm_goods_category where gender=#{gender} ")
    public List<ProductCategory> queryProductCategoryByGender(@Param("gender") Integer gender);

    @Select("select id,category_name from dm_goods_category where id=#{category} ")
    ProductCategory queryProductCategoryById(@Param("category") Integer category);



    public List<GoodsQuery> queryProductByGoodsDto(GoodsDto goodsDto,PageBounds pageBounds);

    public List<GoodsQuery> showDesignerGoods(Integer id,PageBounds pageBounds);

    public List<GoodsQuery> showBrandDetail(Integer id,PageBounds pageBounds);

    @Select("select type from dm_goods where id=#{productId}")
    public Integer findTypeByProductId(@Param("productId") Integer productId);

    Goods findBProductById(Integer id);

    Goods findDProductById(Integer id);

    @Select("select category_name from dm_goods_category where id=(select product_category from dm_goods where id=#{id})")
    String findProductCategoryById(@Param("id") Integer id);


    List<Size> queryProductSize(GoodsDto goodsDto);


    List<Material> queryProductMaterial(GoodsDto goodsDto);


    List<GoodsQuery> selectProductForPage(GoodsDto goodsDto, PageBounds pageBounds);
}
