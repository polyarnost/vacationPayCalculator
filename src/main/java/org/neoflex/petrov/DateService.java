package org.neoflex.petrov;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public interface DateService {

    int getWorkDaysBetween(LocalDate startDate, LocalDate endDate);
}
