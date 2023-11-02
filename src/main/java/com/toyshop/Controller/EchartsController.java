package com.toyshop.Controller;

import com.toyshop.Controller.utils.R;
import com.toyshop.Service.serviceImpl.EchartsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    private EchartsImpl echartsImpl;

    @GetMapping("/incomeNum")
    public R getWeekIncome(){
        return new R(200,echartsImpl.getWeekIncome());
    }

    @GetMapping("/profittop")
    public R getProfitTop(){
        return new R(200,echartsImpl.getProfitTop());
    }

    @GetMapping("/damcount")
    public R getDamcount(){
        return new R(200,echartsImpl.getDamCount());
    }

}
