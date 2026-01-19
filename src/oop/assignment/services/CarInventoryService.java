package oop.assignment.services;

import oop.assignment.entities.Car;
import oop.assignment.exceptions.CarNotAvailableException;
import oop.assignment.repositories.interfaces.ICarRepository;
import java.sql.SQLException;
import java.util.List;

public class CarInventoryService {
    private final ICarRepository carRepo;

    public CarInventoryService(ICarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public Car getReadyCar(int id) throws SQLException, CarNotAvailableException {
        Car car = carRepo.findById(id);
        if (car == null) {
            throw new CarNotAvailableException(id);
        }
        if (!car.isAvailable()) {
            throw new CarNotAvailableException(id);
        }
        return car;
    }
    public void registerNewCar(Car car) throws SQLException {
        carRepo.add(car);
    }
    public List<Car> getAllCars() throws SQLException {
        return carRepo.findAll();
    }
    public List<Car> getOnlyAvailableCars() throws SQLException {
        return carRepo.findAvailable();
    }
}