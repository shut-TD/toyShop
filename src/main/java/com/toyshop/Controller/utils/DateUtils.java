package com.toyshop.Controller.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DateUtils {
    public List<LocalDate> getCurrentWeek(){
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY)).plusWeeks(0);
        LocalDate endOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY)).plusWeeks(0);
        List<LocalDate> currentWeek = new ArrayList<>();
        for (LocalDate date = startOfWeek; date.isBefore(endOfWeek); date = date.plusDays(1)) {
            currentWeek.add(date);
        }
        currentWeek.add(endOfWeek);
        return currentWeek;
    }
}
