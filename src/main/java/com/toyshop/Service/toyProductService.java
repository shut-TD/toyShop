package com.toyshop.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.toyshop.Dao.toyProductDao;
import com.toyshop.Entity.ToyProduct;
import com.toyshop.Entity.Vip;
import org.springframework.stereotype.Service;

@Service
public interface toyProductService extends IService<ToyProduct> {
    IPage<ToyProduct> getPage(int currentPage, int pageSize);
    IPage<ToyProduct> getPage(int currentPage,int pageSize,ToyProduct toyProduct);
}
