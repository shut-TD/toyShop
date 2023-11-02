package com.toyshop.Service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toyshop.Dao.vipDao;
import com.toyshop.Entity.Vip;
import com.toyshop.Service.vipService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vipImpl extends ServiceImpl<vipDao, Vip> implements vipService {

    @Autowired
    private vipDao vipDao;
    
    @Override
    public IPage<Vip> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        vipDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Vip> getPage(int currentPage, int pageSize, Vip vip) {
        LambdaQueryWrapper<Vip> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(vip.getVipName()),Vip::getVipName,vip.getVipName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(vip.getVipId()),Vip::getVipId,vip.getVipId());
        IPage page = new Page(currentPage,pageSize);
        vipDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }

}
