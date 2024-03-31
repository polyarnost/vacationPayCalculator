package org.neoflex.petrov;

import org.springframework.stereotype.Component;

@Component
public class VacationCalculator {

    public double calculateVacationAllowance(double averageSalary, int vacationDays, int workDays) {
        return averageSalary / 12 * vacationDays * workDays;
    }
}
