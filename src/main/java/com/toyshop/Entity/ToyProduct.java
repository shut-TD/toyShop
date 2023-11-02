package com.toyshop.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ToyProduct {
    @TableId(type = IdType.UUID)
    private String toyId;

    private String toyName;
    private double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate buytime;
    private int annexNumber;
    private String damSituation;
    private String isBroken;
}
