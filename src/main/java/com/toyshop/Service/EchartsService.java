package com.toyshop.Service;

import com.toyshop.Entity.TempEntity.DamSituation;
import com.toyshop.Entity.TempEntity.ProfitTop;
import com.toyshop.Entity.ToyProduct;

import java.util.List;

public interface EchartsService {
    List getWeekIncome();
    List<ProfitTop> getProfitTop();
    List<DamSituation> getDamCount();
}
