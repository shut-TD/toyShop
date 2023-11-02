package com.toyshop.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toyshop.Entity.ToyProduct;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface toyProductDao extends BaseMapper<ToyProduct> {
    List<ToyProduct> listToyproduct();
    boolean insertToy(ToyProduct toyProduct);
    boolean delToy(String toyId);
    boolean updateToy(ToyProduct toyProduct);
    int getWeekIncome(LocalDate localDate);
    int getDamCount(String Damsituation);
}
