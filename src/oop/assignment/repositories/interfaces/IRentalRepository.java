package oop.assignment.repositories.interfaces;

import oop.assignment.entities.Rental;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IRentalRepository {
    void add(Rental rental) throws SQLException;
    Rental findById(int id) throws SQLException;
    List<Rental> getAll() throws SQLException;
    List<Rental> findByCarId(int carId) throws SQLException;
    List<Rental> findByCustomerId(int customerId) throws SQLException;
    boolean hasOverlappingRental(int carId, LocalDate startDate, LocalDate endDate) throws SQLException;
}