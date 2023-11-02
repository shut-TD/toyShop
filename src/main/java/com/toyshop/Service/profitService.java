package com.toyshop.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.toyshop.Entity.Profit;
import org.springframework.stereotype.Service;

@Service
public interface profitService extends IService<Profit> {
    IPage<Profit> getPage(int currentPage, int pageSize);
    IPage<Profit> getPage(int currentPage,int pageSize,Profit profit);
}
