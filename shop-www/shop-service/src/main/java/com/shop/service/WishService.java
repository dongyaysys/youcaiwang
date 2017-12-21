package com.shop.service;/**
 * Created by 17173 on 2017/12/21.
 */

import com.shop.dao.WishDao;
import com.shop.query.BrandDesignerQuery;
import com.shop.query.GoodsQuery;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DY
 * @create 2017-12-21 14:50
 **/
@Service
public class WishService {

    @Autowired
    private WishDao wishDao;

    public Map<Object,Object> findWish(Integer userId) {
        AssertUtil.intIsNotEmpty(userId,"请传入用户Id");
        Map<Object,Object> map= new HashMap<Object,Object>();

        List<GoodsQuery> goods=wishDao.findWishGoods(userId);
        List<BrandDesignerQuery> brandsAndDesigner=wishDao.findBrandsAndDesigner(userId);

        map.put("brandsAndDesigner",brandsAndDesigner);
        map.put("goods",goods);
        if(null==goods||goods.size()==0&&null==brandsAndDesigner||brandsAndDesigner.size()==0){
            map=null;
        }
        return map;

    }
}
