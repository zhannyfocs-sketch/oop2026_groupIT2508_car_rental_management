package oop.assignment.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rental {
    private int id;
    private int carId;
    private int customerId;
    private LocalDate startdate;
    private LocalDate enddate;
    private BigDecimal totalcost;
    private String status;

    public Rental(){}

    public Rental(int carId, int customerId, LocalDate startdate, LocalDate enddate, BigDecimal totalcost, String status) {
        setCarId(carId);
        setCustomerId(customerId);
        setStartdate(startdate);
        setEnddate(enddate);
        setTotalcost(totalcost);
        setStatus(status);
    }
    public Rental(int id, int carId, int customerId, BigDecimal totalcost, String status) {
        this(carId, customerId, LocalDate.now(), LocalDate.now(), totalcost, status);
        setId(id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }
    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public BigDecimal getTotalcost() {
        return totalcost;
    }
    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public long getRentalDays() {
        if (startdate == null || enddate == null)
            return 0;
        return enddate.toEpochDay() - startdate.toEpochDay();
    }

    @Override
    public String toString() {
        long days = getRentalDays();
        return "Rental" + id + "Car ID" + carId + "Customer's ID" + customerId
                + "Start date: " + startdate + "End date: " + enddate + "Total dats" + days
                + "Total cost: " + totalcost;
    }

}