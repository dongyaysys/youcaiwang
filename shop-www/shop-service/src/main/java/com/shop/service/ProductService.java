package com.shop.service;
/**
 * Created by 17173 on 2017/12/14.
 */

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shop.dao.GoodsDao;
import com.shop.exception.ParamException;
import com.shop.gto.GoodsDto;
import com.shop.model.*;
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
 * @author DY
 * @create 2017-12-14 15:12
 **/
@Service
public class ProductService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ReviewService reviewService;


    public Map<Object,Object> productDetail(Integer id,GoodsDto goodsDto) {

        if(null==id||id<1){
            throw new ParamException("请选择商品Id");
        }
        Integer type=goodsDao.findTypeByProductId(id);
        goodsDto.setGoods(id);

        Map<Object,Object> map= new HashMap<Object,Object>();

        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句
        List<ReviewQuery> reviews = reviewService.queryReviews(goodsDto,pageBounds);

        // 構建返回結果
        PageList<ReviewQuery> reviewsPageList = (PageList<ReviewQuery>)reviews;

        ReviewQuery reviewQuery=IndexService.returnReviewQuery(reviews);

        //構建paginator 返回
        Paginator paginator= reviewsPageList.getPaginator();
        map.put("paginator", paginator);

        List<Size> productSize=goodsDao.queryProductSize(goodsDto);
        List<Material> productMaterial=goodsDao.queryProductMaterial(goodsDto);

        Goods goods=new Goods();
        String productCategoryName=goodsDao.findProductCategoryById(id);

        if(null==type||type<1){
            throw new ParamException("此商品未分品类");
        }
        //判断是属于设计师还是品牌
        if(type==1){
             goods=goodsDao.findBProductById(id);
        }
        if(type==2){
             goods=goodsDao.findDProductById(id);
        }

        goods.setProductCategory(productCategoryName);
        goods.setSize(productSize);
        goods.setMaterial(productMaterial);
        map.put("reviews",reviewsPageList);
        map.put("goods",goods);
        if(0==paginator.getTotalCount()){
            map=null;
        }
        return map;
    }

    /**
    *@author DY
    *@create 2017/12/20 13:57
    *选择商品尺寸接口,非定制类,套码
    */

    public Map<Object,Object> chooseProduct(GoodsDto goodsDto) {
        Map<Object,Object> map= new HashMap<Object,Object>();
        AssertUtil.intIsNotEmpty(goodsDto.getGoods(),"请选择商品");

        List<Size> size=null;
        List<Material> material=null;
        if(null==goodsDto.getMaterial()&&null==goodsDto.getSize()){
            throw new ParamException("请选择尺码或者颜色");
        }

        if(goodsDto.getSize()!=null&&null==goodsDto.getMaterial()){
             material=goodsDao.queryProductMaterial(goodsDto);
             map.put("material",material);
        }
        if(goodsDto.getSize()==null&&null!=goodsDto.getMaterial()){
             size=goodsDao.queryProductSize(goodsDto);
             map.put("size",size);
        }
        if(null==material&&0==size.size()||null==size&&0==material.size()){
            map=null;
        }

        return map;


    }


    public Map<Object,Object> selectProductForPage(GoodsDto goodsDto) {

        Map<Object, Object> map = new HashMap<Object, Object>();
        AssertUtil.notNull(goodsDto,"请输入搜索内容");
        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句
        List<GoodsQuery> goods=goodsDao.selectProductForPage(goodsDto,pageBounds);

        // 構建返回結果
        PageList<GoodsQuery> goodsPageList = (PageList<GoodsQuery>)goods;

        //構建paginator對象返回
        Paginator paginator= goodsPageList.getPaginator();
        map.put("goods",goodsPageList);
        map.put("paginator", paginator);
        if(0==paginator.getTotalCount()){
            map=null;
        }
        return map;
    }
}
