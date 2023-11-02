package com.toyshop.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Profit {
    @TableId(type = IdType.UUID)
    private String tradeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String vipName;
    private String vipId;
    private String toyName;
    private String toyId;
    private int toyProfit;
    private String toyToClerk;
    private String clerkId;
}
