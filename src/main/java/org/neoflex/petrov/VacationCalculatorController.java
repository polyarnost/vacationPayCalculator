package org.neoflex.petrov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VacationCalculatorController {

    private final VacationCalculator vacationCalculator;
    private final SimpleDateService simpleDateService;

    @Autowired
    public VacationCalculatorController(VacationCalculator vacationCalculator, SimpleDateService simpleDateService) {
        this.vacationCalculator = vacationCalculator;
        this.simpleDateService = simpleDateService;
    }

    @GetMapping("/calculate")
    public double calculateVacation(@RequestParam double averageSalary, @RequestParam int vacationDays,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        int workDays = simpleDateService.getWorkDaysBetween(startDate, endDate);
        return vacationCalculator.calculateVacationAllowance(averageSalary, vacationDays, workDays);
    }
}