package com.shop.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.gto.GoodsDto;
import com.shop.model.*;
import com.shop.query.GoodsQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sun.reflect.generics.repository.GenericDeclRepository;

import java.util.List;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface GoodsDao {

    @Select("select id,image,name,caption,is_custom,price,sales from dm_goods where version=1 ")
    public List<GoodsQuery> queryGoods();


    @Select("select id,image,product_scene from dm_goods_scene where gender=gender ")
    public List<ProductScene> querySceneByGender(@Param("gender") Integer gender);


    @Select("select id, product_category from dm_goods_category where gender=gender ")
    public List<ProductCategory> queryProductSceneByGender(@Param("gender") Integer gender);



    public List<GoodsQuery> queryProductByGoodsDto(GoodsDto goodsDto,PageBounds pageBounds);

    public List<GoodsQuery> showDesignerGoods(Integer id);

    public List<GoodsQuery> showBrandDetail(Integer id);

    @Select("select type from dm_goods where id=#{productId}")
    public Integer findTypeByProductId(@Param("productId") Integer productId);

    Goods findBProductById(Integer id);

    Goods findDProductById(Integer id);

    @Select("select product_category from dm_goods_category where id=(select product_category from dm_goods where id=#{id})")
    String findProductCategoryById(@Param("id") Integer id);

    @Select("select DISTINCT s.id,s.size from dm_psc psc LEFT JOIN dm_size s ON s.id=psc.size WHERE psc.goods=#{id}")
    List<Size> queryProductSizeById(@Param("id") Integer id);

    @Select("select DISTINCT m.id,m.material from dm_psc psc LEFT JOIN dm_material m ON m.id=psc.material WHERE psc.goods=#{id}")
    List<Material> queryProductMaterialById(@Param("id") Integer id);


}
