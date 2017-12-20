package com.shop.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.shop.dao.DesignerDao;
import com.shop.dao.GoodsDao;
import com.shop.exception.ParamException;
import com.shop.gto.GoodsDto;
import com.shop.model.Designer;
import com.shop.model.ProductCategory;
import com.shop.query.DesignerQuery;
import com.shop.query.GoodsQuery;
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
public class DesignerService {

    @Autowired
    private DesignerDao designerDao;
    @Autowired
    private GoodsDao goodsDao;

    public List<DesignerQuery> showHotDesignders(){

        List<DesignerQuery> designers=designerDao.showHotDesignders();
        return designers;
    }

    /**
     *@author DY
     *@create 2017/12/13 17:38
     *品牌最新品牌入驻
     */
    public List<DesignerQuery> showRecentDesignders(){

        List<DesignerQuery> recentDesigners=designerDao.showRecentDesignders();
        return recentDesigners;
    }
    /**
     *@author DY
     *@create 2017/12/13 17:39
     *最受欢迎品牌
     */
    public List<DesignerQuery> showPopularDesignders(){

        List<DesignerQuery> popularDesigners=designerDao.showPopularDesignders();
        return popularDesigners;
    }

    /**
    *@author DY
    *@create 2017/12/14 12:15
    *设计师详情展示
    */
    public Map<Object,Object> showDesignerDetail(Integer id, GoodsDto goodsDto) {

        Map<Object, Object> map = new HashMap<Object, Object>();

        if(null==id||id<1){
            throw new ParamException("请选择要查询的设计师");
        }
        Designer  designer=designerDao.showDesignerDetail(id);
        if(designer==null){
            throw new ParamException("该设计师不存在");
        }

        // 構建pageBounds
        PageBounds pageBounds = goodsDto.buildPageBounds();
        // 調用查詢語句

        List<GoodsQuery> goods=goodsDao.showDesignerGoods(id,pageBounds);
        AssertUtil.notNull(goods,"该设计师暂时没有作品");
        // 構建返回結果
        PageList<GoodsQuery> goodsPageList = (PageList<GoodsQuery>)goods;

        //構建paginator 返回
        Paginator paginator= goodsPageList.getPaginator();

        List<ProductCategory> productCategory=returnProductCategory(goods);
        map.put("productCategory",productCategory);
        map.put("paginator", paginator);
        map.put("designer",designer);
        map.put("goods",goods);

        return map;

    }

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

	public List<DesignerQuery> queryBrandDesignersByName() {
        return designerDao.queryBrandDesignersByName();
	}

}
