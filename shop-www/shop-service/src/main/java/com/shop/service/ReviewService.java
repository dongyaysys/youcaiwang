package com.shop.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.dao.ReviewDao;
import com.shop.gto.GoodsDto;
import com.shop.query.ReviewQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 */
@Service
public class ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    public List<ReviewQuery> queryReviews(GoodsDto goodsDto, PageBounds pageBounds){

        List<ReviewQuery> reviews=reviewDao.queryReviews(goodsDto,pageBounds);
        return reviews;
    }

}
