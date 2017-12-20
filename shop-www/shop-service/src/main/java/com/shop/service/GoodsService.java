package com.shop.service;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.dao.GoodsDao;
import com.shop.gto.GoodsDto;
import com.shop.model.Goods;
import com.shop.model.ProductCategory;
import com.shop.model.ProductScene;
import com.shop.query.GoodsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
    *@author DY
    *@create 2017/12/13 10:53
    *查询单品精选商品
    */
    public List<GoodsQuery> queryGoods(){

        List<GoodsQuery> goods=goodsDao.queryGoods();
        return goods;
    }

    /**
    *@author DY
    *@create 2017/12/13 10:53
    *查询场合分类 根据男装女装
    */


    public List<ProductScene> queryProductScene(Integer gender){

        List<ProductScene> sceneList=new ArrayList();

            sceneList=goodsDao.querySceneByGender(gender);
            return sceneList;
    }

    /**
    *@author DY
    *@create 2017/12/13 13:55
    *根据衣服种类进行分类
    */
    public List<ProductCategory> queryProductCategoryByGender(Integer gender){
        List<ProductCategory> productCategory=new ArrayList();

        productCategory=goodsDao.queryProductCategoryByGender(gender);

        return productCategory;


    }
    /**
    *@author DY
    *@create 2017/12/13 13:55
    *根据衣服性别进行分类
    */
    public List<GoodsQuery> queryProductByGender(GoodsDto goodsDto,PageBounds pageBounds){
            List<GoodsQuery> goods=new ArrayList();
            goods=goodsDao.queryProductByGoodsDto(goodsDto,pageBounds);
            return goods;

    }



}
