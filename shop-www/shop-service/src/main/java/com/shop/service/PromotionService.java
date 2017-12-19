package com.shop.service;

import com.shop.dao.DesignerDao;
import com.shop.dao.PromotionDao;
import com.shop.model.Designer;
import com.shop.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 17173 on 2017/12/8.
 */
@Service
public class PromotionService {

    @Autowired
    private PromotionDao promotionDao;

    public List<Promotion> showPromotion(){
        return promotionDao.showPromotion();
    }
}
