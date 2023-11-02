package com.toyshop.Service.serviceImpl;

import com.toyshop.Controller.utils.DateUtils;
import com.toyshop.Controller.utils.RedisUtils;
import com.toyshop.Dao.profitDao;
import com.toyshop.Dao.toyProductDao;
import com.toyshop.Entity.TempEntity.DamSituation;
import com.toyshop.Entity.TempEntity.ProfitTop;
import com.toyshop.Service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EchartsImpl implements EchartsService {

    @Autowired
    private toyProductDao toyProductDao;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private profitDao profitDao;

    @Override
    public List getWeekIncome() {
//        redis缓存
        if (redisUtils.get("currentWeekIncome") != null){
            return (List) redisUtils.get("currentWeekIncome");
        }
        List<LocalDate> currentWeek = dateUtils.getCurrentWeek();
        List currentWeekIncome = new ArrayList<>();
        for (LocalDate localDate : currentWeek) {
            currentWeekIncome.add(toyProductDao.getWeekIncome(localDate));
        }
        redisUtils.set("currentWeekIncome",currentWeekIncome,60L);
        return currentWeekIncome;
    }

    @Override
    public List<ProfitTop> getProfitTop() {
//        redis缓存
        if (redisUtils.get("profitTop") != null) return (List<ProfitTop>) redisUtils.get("profitTop");
        List<ProfitTop> profitTop = profitDao.getTopProfit();
        redisUtils.set("profitTop",profitTop,60L);
        return profitTop;
    }

    @Override
    public List<DamSituation> getDamCount() {
        if (redisUtils.get("damList") != null) return (List<DamSituation>) redisUtils.get("damList");
        int noneDam = toyProductDao.getDamCount("未损坏");
        int slightDam = toyProductDao.getDamCount("轻微损坏");
        int moderateDam = toyProductDao.getDamCount("中度损坏");
        int severeDam = toyProductDao.getDamCount("严重损坏");
        List<DamSituation> damSituations = new ArrayList<>();
        DamSituation damSituation1 = new DamSituation();
        damSituation1.setValue(noneDam);
        damSituation1.setName("未损坏件数");

        DamSituation damSituation2 = new DamSituation();
        damSituation2.setValue(slightDam);
        damSituation2.setName("轻微损坏件数");

        DamSituation damSituation3 = new DamSituation();
        damSituation3.setValue(moderateDam);
        damSituation3.setName("中度损坏件数");

        DamSituation damSituation4 = new DamSituation();
        damSituation4.setValue(severeDam);
        damSituation4.setName("严重损坏件数");

        damSituations.add(damSituation1);
        damSituations.add(damSituation2);
        damSituations.add(damSituation3);
        damSituations.add(damSituation4);
        redisUtils.set("damList",damSituations,60L);
        System.out.println("redis");
        return damSituations;
    }
}
