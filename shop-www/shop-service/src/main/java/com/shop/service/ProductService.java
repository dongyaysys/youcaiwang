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
import com.shop.model.Goods;
import com.shop.model.Material;
import com.shop.model.Size;
import com.shop.query.ReviewQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<Size> productSize=goodsDao.queryProductSizeById(id);
        List<Material> productMaterial=goodsDao.queryProductMaterialById(id);

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

        map.put("reviews",reviews);
        map.put("goods",goods);
        return map;



    }
}
