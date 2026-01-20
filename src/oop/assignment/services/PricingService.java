package oop.assignment.services;

import oop.assignment.entities.Car;
import oop.assignment.entities.Rental;
import oop.assignment.exceptions.InvalidPaymentAmount;
import java.math.BigDecimal;

public class PricingService {
    private static final BigDecimal insuranceFee = new BigDecimal("20000");
    private static final BigDecimal accidentFee = new BigDecimal("50000");

    public BigDecimal calculateTotal(Car car, Rental rental, boolean hadAccident) {
        long days = rental.getRentalDays();
        if (days <= 0) {
            days = 1;
        }
        BigDecimal base = car.getRate().multiply(BigDecimal.valueOf(days));
        BigDecimal total = base.add(insuranceFee);

        if (hadAccident) {
            total = total.add(accidentFee);
        }
        if (total.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentAmount("Payment must be a positive value.");
        }
        return total;
    }
}