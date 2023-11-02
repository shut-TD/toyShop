package com.toyshop.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toyshop.Entity.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

@Mapper
public interface vipDao extends BaseMapper<Vip> {
    boolean updateVip(@Param("vipDate") LocalDate vipDate,@Param("vipName") String vipName,@Param("vipAddr") String vipAddr,@Param("vipPhone") String vipPhone,@Param("vipIntegral") int vipIntegral,@Param("vipDeposit") int vipDeposit,@Param("vipTag") String vipTag,@Param("vipId") String vipId);
    boolean delVip(String vipId);
}
