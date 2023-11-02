package com.toyshop.Service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toyshop.Dao.clerkDao;
import com.toyshop.Entity.Clerk;
import com.toyshop.Service.clerkService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clerkImpl extends ServiceImpl<clerkDao, Clerk> implements clerkService {

    @Autowired
    private clerkDao clerkDao;

    @Override
    public IPage<Clerk> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        clerkDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Clerk> getPage(int currentPage, int pageSize, Clerk clerk) {
        LambdaQueryWrapper<Clerk> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(clerk.getClerkName()),Clerk::getClerkName,clerk.getClerkName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(clerk.getClerkId()),Clerk::getClerkId,clerk.getClerkId());
        IPage page = new Page(currentPage,pageSize);
        clerkDao.selectPage(page,lambdaQueryWrapper);
        return page;
    }
}
