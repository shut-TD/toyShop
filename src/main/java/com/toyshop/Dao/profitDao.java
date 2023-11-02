package com.toyshop.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toyshop.Entity.Profit;
import com.toyshop.Entity.TempEntity.ProfitTop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface profitDao extends BaseMapper<Profit> {
    boolean delByTradeId(String tradeId);
    boolean updateProfit(Profit profit);
    List<ProfitTop> getTopProfit();
}
