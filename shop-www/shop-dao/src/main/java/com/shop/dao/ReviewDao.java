package com.shop.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.gto.GoodsDto;
import com.shop.query.ReviewQuery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 17173 on 2017/12/11.
 */
public interface ReviewDao {


    public List<ReviewQuery> queryReviews(GoodsDto goodsDto, PageBounds pageBounds);


}
