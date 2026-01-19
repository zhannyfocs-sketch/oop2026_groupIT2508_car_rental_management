package oop.assignment.services;

import oop.assignment.entities.Car;
import oop.assignment.entities.Customer;
import oop.assignment.entities.Rental;
import oop.assignment.exceptions.CarNotAvailableException;
import oop.assignment.exceptions.InvalidDriverAgeException;
import oop.assignment.exceptions.RentalOverlapException;
import oop.assignment.repositories.interfaces.ICarRepository;
import oop.assignment.repositories.interfaces.ICustomerRepository;
import oop.assignment.repositories.interfaces.IRentalRepository;

import java.sql.SQLException;
import java.util.List;

public class RentalService {
    private final IRentalRepository rentalRepo;
    private final ICarRepository carRepo;
    private final ICustomerRepository customerRepo;

    public RentalService(IRentalRepository rentalRepo,
                         ICarRepository carRepo,
                         ICustomerRepository customerRepo) {
        this.rentalRepo = rentalRepo;
        this.carRepo = carRepo;
        this.customerRepo = customerRepo;
    }

    public void createRental(Rental rental)
            throws SQLException, CarNotAvailableException, RentalOverlapException, InvalidDriverAgeException {
        Customer customer = customerRepo.findById(rental.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("Customer not found with ID: " + rental.getCustomerId());
        }
        if (customer.getAge() < 18) {
            throw new InvalidDriverAgeException(customer.getAge());
        }
        Car car = carRepo.findById(rental.getCarId());
        if (car == null || !car.isAvailable()) {
            throw new CarNotAvailableException(rental.getCarId());
        }
        if (rentalRepo.hasOverlappingRental(rental.getCarId(), rental.getStartDate(), rental.getEndDate())) {
            throw new RentalOverlapException(rental.getCarId(), rental.getStartDate(), rental.getEndDate());
        }
        rentalRepo.add(rental);
    }

    public void cancelRental(int id) throws SQLException {
        Rental rental = rentalRepo.findById(id);
        if (rental == null) {
            throw new RuntimeException("Rental record ID " + id + " not found.");
        }
        rental.setStatus("cancelled");
    }
    public List<Rental> getRentalsByCustomer(int customerId) throws SQLException {
        return rentalRepo.findAll().stream()
                .filter(r -> r.getCustomerId() == customerId)
                .toList();
    }

    public List<Rental> getAllRentals() throws SQLException {
        return rentalRepo.findAll();
    }
}