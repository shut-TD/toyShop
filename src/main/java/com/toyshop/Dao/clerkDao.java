package com.toyshop.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toyshop.Entity.Clerk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface clerkDao extends BaseMapper<Clerk> {
    boolean insertClerk(Clerk clerk);
    List<Clerk> getAllClerk();
    boolean updateClerk(@Param("clerkId") String clerkId,@Param("clerkDate") LocalDate clerkDate,@Param("clerkName") String clerkName);
    boolean deleteByClerkId(String clerkId);
}
