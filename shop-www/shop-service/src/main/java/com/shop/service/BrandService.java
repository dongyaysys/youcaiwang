package com.shop.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shop.dao.BrandDao;
import com.shop.dao.GoodsDao;
import com.shop.exception.ParamException;
import com.shop.gto.GoodsDto;
import com.shop.model.Brand;
import com.shop.model.ProductCategory;
import com.shop.query.BrandQuery;
import com.shop.query.GoodsQuery;
import com.shop.query.ReviewQuery;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Map<Object,Object> showBrandDetail(Integer id,GoodsDto goodsDto) {

        Map<Object, Object> map = new HashMap<Object, Object>();

        if(null==id||id<1){
            throw new ParamException("请选择查询品牌");
        }


        Brand  brand=brandDao.showBrandDetail(id);
        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句
        List<GoodsQuery> goods=goodsDao.showBrandDetail(id,pageBounds);
        AssertUtil.notNull(goods,"该品牌暂时未上架没有货品");
        // 構建返回結果
        PageList<GoodsQuery> brandPageList = (PageList<GoodsQuery>)goods;

        //構建paginator 返回
        Paginator paginator= brandPageList.getPaginator();

        List<ProductCategory> productCategory=returnProductCategory(goods);
        map.put("productCategory",productCategory);
        map.put("paginator", paginator);
        map.put("brand",brand);
        map.put("goods",brandPageList);

        return map;

    }

    /**
    *@author DY
    *@create 2017/12/20 16:20
    *构建设计师/品牌下的商品类别统计
    */

    public List<ProductCategory> returnProductCategory(List<GoodsQuery> goodsQuery){
        List<ProductCategory> productCategory=new ArrayList<>();
        GoodsQuery goods=new GoodsQuery();
        for(int i = 0 ; i < goodsQuery.size() ; i++) {
            Integer category=goodsQuery.get(i).getProductCategory();
            ProductCategory str=goodsDao.queryProductCategoryById(category);
            productCategory.add(str);
        }


        return productCategory;


    }






    public List<BrandQuery>  queryBrandDesigners() {

        return brandDao.queryBrandDesignersByName();
    }
}
