package oop.assignment.exceptions;

import java.time.LocalDate;

public class RentalOverlapException extends Exception {
    private final int carId;
    private final LocalDate start;
    private final LocalDate  end;

    public RentalOverlapException(int carId, LocalDate startDate, LocalDate endDate) {
        super("Car ID " + carId + " is unavailable for the period: " + startDate + " to " + endDate);
        this.carId = carId;
        this.start = startDate;
        this.end = endDate;
    }

    public int getCarId() { return carId; }
    public LocalDate getRequestedStart() { return start; }
    public LocalDate getRequestedEnd() { return end; }
}