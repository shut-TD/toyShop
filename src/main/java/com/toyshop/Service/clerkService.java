package com.toyshop.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.toyshop.Entity.Clerk;
import org.springframework.stereotype.Service;

@Service
public interface clerkService extends IService<Clerk> {
    IPage<Clerk> getPage(int currentPage, int pageSize);
    IPage<Clerk> getPage(int currentPage,int pageSize,Clerk clerk);
}
