package com.toyshop.Service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toyshop.Dao.profitDao;
import com.toyshop.Dao.toyProductDao;
import com.toyshop.Entity.Profit;
import com.toyshop.Entity.ToyProduct;
import com.toyshop.Service.profitService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class profitImpl extends ServiceImpl<profitDao, Profit> implements profitService {
    @Autowired
    private profitDao profitDao;

    @Override
    public IPage<Profit> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        profitDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Profit> getPage(int currentPage, int pageSize, Profit profit) {
        LambdaQueryWrapper<Profit> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(profit.getToyId()),Profit::getToyId,profit.getToyId());
        lambdaQueryWrapper.like(Strings.isNotEmpty(profit.getClerkId()),Profit::getClerkId,profit.getClerkId());
        IPage page = new Page(currentPage,pageSize);
        profitDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
