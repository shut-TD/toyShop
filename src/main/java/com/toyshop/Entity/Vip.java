package com.toyshop.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Vip {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate vipDate;

    @TableId(type = IdType.ASSIGN_UUID)
    private String vipId;

    private String vipName;
    private String vipAddr;
    private String vipPhone;
    private int vipIntegral;
    private int vipDeposit;
    private String vipTag;
}
