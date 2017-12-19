package com.shop.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.dao.BrandDao;
import com.shop.gto.GoodsDto;
import com.shop.model.Goods;
import com.shop.model.ProductCategory;
import com.shop.model.ProductScene;
import com.shop.model.Promotion;
import com.shop.query.*;
import com.shop.util.AssertUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.Collator;
import java.util.*;

/**
 * Created by 17173 on 2017/12/8.
 */
@Service
public class IndexService {

    @Autowired
    private DesignerService designerService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ReviewService reviewService;

    public  Map<Object,Object> recommendShow(){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        List<DesignerQuery> designers=designerService.showHotDesignders();
        List<BrandQuery> brands=brandService.showHotBrands();
        List<Promotion> promotion=promotionService.showPromotion();
        List<GoodsQuery> goods=goodsService.queryGoods();

        //构建精选设计师返回对象
        map.put("designers",designers);
        //构建精选品牌返回对象
        map.put("brands",brands);
        //构建精选活动返回对象
        map.put("promotions",promotion);
        //构建单品精选活动返回对象
        map.put("goods",goods);

        return map;

    }

    /**
     *@author DY
     *@create 2017/12/12 12:06
     *精选评论表
     */

    public  Map<Object,Object> lookShow(GoodsDto goodsDto){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句
        List<ReviewQuery> reviews = reviewService.queryReviews(goodsDto,pageBounds);

        // 構建返回結果
        PageList<ReviewQuery> reviewsPageList = (PageList<ReviewQuery>)reviews;
        ReviewQuery reviewQuery=returnReviewQuery(reviews);

        //構建paginator對象返回
        Paginator paginator= reviewsPageList.getPaginator();
        map.put("paginator", paginator);

        map.put("reviews",reviewsPageList);

        return map;

    }
    /**
    *@author DY
    *@create 2017/12/18 11:49
    *构建评论图片list装在ReviewQuery里
    */

    public static ReviewQuery returnReviewQuery(List<ReviewQuery> reviews){
        ReviewQuery reviewQuery=new ReviewQuery();

        for(int i = 0; i < reviews.size(); i++){

            List<String> list = new ArrayList<>();
            reviewQuery=reviews.get(i);
            if(reviewQuery.getReviewPic1() != null)
                list.add(reviewQuery.getReviewPic1());
            if(reviewQuery.getReviewPic2() != null)
                list.add(reviewQuery.getReviewPic2());
            if(reviewQuery.getReviewPic3() != null)
                list.add(reviewQuery.getReviewPic3());
            reviewQuery.setImagelist(list);
        }

        return reviewQuery;

    }


    public  Map<Object,Object> chooseShow(GoodsDto goodsDto) {

        Map<Object, Object> map = new HashMap<Object, Object>();
        if(null==goodsDto){
            goodsDto.setGender(2);
        }

        List<ProductScene> sceneList=goodsService.queryProductScene(goodsDto.getGender());
        List<ProductCategory> productCategory=goodsService.queryProductCategory(goodsDto.getGender());

        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句
        List<GoodsQuery> goods=goodsService.queryProductByGender(goodsDto,pageBounds);

        // 構建返回結果
        PageList<GoodsQuery> goodsPageList = (PageList<GoodsQuery>)goods;

        //構建paginator對象返回
        Paginator paginator= goodsPageList.getPaginator();
        map.put("goods",goodsPageList);
        map.put("paginator", paginator);
        map.put("sceneList",sceneList);
        map.put("productCategory",productCategory);
        return map;

    }

    public  Map<Object,Object> showBrandDesigner(Integer type) {

        Map<Object, Object> map = new HashMap<Object, Object>();
        List recentBrandsDesigners=new ArrayList<>();
        List popularBrandDesigners=new ArrayList<>();
        List brandDesignersByName=new ArrayList<>();
        //AssertUtil.intIsNotEmpty(type,"请选择要查看的设计师或者品牌");

        if(null==type||type==2){
            recentBrandsDesigners=designerService.showRecentDesignders();
            popularBrandDesigners=designerService.showPopularDesignders();
            brandDesignersByName=designerService.queryBrandDesignersByName();
        }
        else{
            recentBrandsDesigners=brandService.showRecentBrands();
            popularBrandDesigners=brandService.showPopularBrand();
            brandDesignersByName=brandService.queryBrandDesigners();


        }



        map.put("recentBrandsDesigners",recentBrandsDesigners);
        map.put("popularBrandDesigners",popularBrandDesigners);
        map.put("brandDesigners",brandDesignersByName);

        return map;

    }


}
