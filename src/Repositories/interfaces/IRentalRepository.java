package Repositories.interfaces;

import models.Rental;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IRentalRepository {
    void add(Rental rental) throws SQLException;
    List<Rental> getRentals() throws SQLException;
    List<Rental> getRentals(LocalDate startDate, LocalDate endDate) throws SQLException;
}
