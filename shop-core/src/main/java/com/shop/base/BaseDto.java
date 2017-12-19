package com.shop.base;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shop.constant.Constant;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by TW on 2017/10/27.
 */
public class BaseDto implements Serializable {

    private Integer page ;
    private Integer pageSize ;
    private String sort;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 構建pageBounds
     * @return
     */
    public PageBounds buildPageBounds() {
        if (page == null) {
            page = Constant.ONE;
        }
        if (pageSize == null) {
            pageSize = Constant.TEN;
        }
        PageBounds pageBounds = new PageBounds(page, pageSize);
        if (StringUtils.isNotBlank(sort)) {
            pageBounds.setOrders(Order.formString(sort));
        }
        return pageBounds;
    }

}
