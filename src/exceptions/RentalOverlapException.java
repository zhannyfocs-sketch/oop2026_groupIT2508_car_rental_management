package exceptions;

import java.time.LocalDate;

public class RentalOverlapException extends Exception {
    private final int carId;
    private final LocalDate start;
    private final LocalDate  end;

    public RentalOverlapException(int carId, LocalDate startdate, LocalDate enddate) {
        super("Car ID " + carId + " is unavailable for the period: " + startdate + " to " + enddate);
        this.carId = carId;
        this.start = startdate;
        this.end = enddate;
    }

    public int getCarId() { return carId; }
    public LocalDate getRequestedStart() { return start; }
    public LocalDate getRequestedEnd() { return end; }
}