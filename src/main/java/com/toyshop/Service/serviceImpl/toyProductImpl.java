package com.toyshop.Service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toyshop.Dao.toyProductDao;
import com.toyshop.Entity.ToyProduct;
import com.toyshop.Service.toyProductService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class toyProductImpl extends ServiceImpl<toyProductDao, ToyProduct> implements toyProductService {
    @Autowired
    private toyProductDao toyProductDao;

    @Override
    public IPage<ToyProduct> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        toyProductDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<ToyProduct> getPage(int currentPage, int pageSize, ToyProduct toyProduct) {
        LambdaQueryWrapper<ToyProduct> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(toyProduct.getToyName()),ToyProduct::getToyName,toyProduct.getToyName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(toyProduct.getToyId()),ToyProduct::getToyId,toyProduct.getToyId());
        IPage page = new Page(currentPage,pageSize);
        toyProductDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
