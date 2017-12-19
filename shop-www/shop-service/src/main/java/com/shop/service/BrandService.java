package com.shop.service;

import com.shop.dao.BrandDao;
import com.shop.dao.GoodsDao;
import com.shop.exception.ParamException;
import com.shop.model.Brand;
import com.shop.query.BrandQuery;
import com.shop.query.GoodsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/8.
 */
@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private GoodsDao goodsDao;

    /**
    *@author DY
    *@create 2017/12/13 17:38
    *秀场品牌精选
    */
    public List<BrandQuery> showHotBrands(){

        List<BrandQuery> brands=brandDao.showHotBrands();
        return brands;
    }
    /**
    *@author DY
    *@create 2017/12/13 17:38
    *品牌最新品牌入驻
    */
    public List<BrandQuery> showRecentBrands(){

        List<BrandQuery> recentBrands=brandDao.showRecentBrands();
        return recentBrands;
    }
    /**
    *@author DY
    *@create 2017/12/13 17:39
    *最受欢迎品牌
    */
    public List<BrandQuery> showPopularBrand(){

        List<BrandQuery> popularBrand=brandDao.showPopularBrand();
        return popularBrand;
    }


    /**
     *@author DY
     *@create 2017/12/14 12:15
     *品牌详情展示
     */
    public Map<Object,Object> showBrandDetail(Integer id) {

        Map<Object, Object> map = new HashMap<Object, Object>();

        if(null==id||id<1){
            throw new ParamException("请选择分类");
        }
        Brand  brand=brandDao.showBrandDetail(id);
        List<GoodsQuery> goods=goodsDao.showBrandDetail(id);
        map.put("brand",brand);
        map.put("goods",goods);

        return map;

    }




    public List<BrandQuery>  queryBrandDesigners() {

        return brandDao.queryBrandDesignersByName();
    }
}
