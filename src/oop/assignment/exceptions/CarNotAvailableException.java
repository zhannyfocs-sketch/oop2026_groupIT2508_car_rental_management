package oop.assignment.exceptions;

public class CarNotAvailableException extends Exception {
    private final int carId;

    public CarNotAvailableException(int id) {
        super("Car with ID " + id + " is currently unavailable for rental.");
        this.carId = id;
    }

    public CarNotAvailableException(int id, String message) {
        super(message);
        this.carId = id;
    }

    public int getCarId() {
        return carId;
    }
}