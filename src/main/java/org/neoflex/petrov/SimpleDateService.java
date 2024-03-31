package org.neoflex.petrov;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Component
public class SimpleDateService implements DateService {

    private final List<LocalDate> holidays;

    public SimpleDateService(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    @Override
    public int getWorkDaysBetween(LocalDate startDate, LocalDate endDate) {
        int workDays = 0;
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY && !holidays.contains(date)) {
                workDays++;
            }
            date = date.plusDays(1);
        }
        return workDays;
    }
}
