package com.toyshop.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.toyshop.Entity.Clerk;
import com.toyshop.Entity.Vip;
import org.springframework.stereotype.Service;

@Service
public interface vipService extends IService<Vip> {
    IPage<Vip> getPage(int currentPage, int pageSize);
    IPage<Vip> getPage(int currentPage,int pageSize,Vip vip);
}
