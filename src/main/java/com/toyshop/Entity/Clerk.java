package com.toyshop.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Clerk {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate clerkDate;
    private String clerkName;
    @TableId(type = IdType.UUID)  //唯一uuid
    private String clerkId;
}
