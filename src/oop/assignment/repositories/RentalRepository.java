package oop.assignment.repositories;

import oop.assignment.db.IDB;
import oop.assignment.entities.Rental;
import oop.assignment.repositories.interfaces.IRentalRepository;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository implements IRentalRepository {
    private final IDB db;

    public RentalRepository(IDB db) {
        this.db = db;
    }

    @Override
    public void add(Rental rental) throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO rentals(car_id, customer_id, start_date, end_date, status) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, rental.getCarId());
            st.setInt(2, rental.getCustomerId());
            st.setDate(3, Date.valueOf(rental.getStartDate()));
            st.setDate(4, Date.valueOf(rental.getEndDate()));
            st.setString(5, rental.getStatus() != null ? rental.getStatus() : "active");

            st.execute();
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public Rental findById(int id) throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, car_id, customer_id, start_date, end_date, total_cost, status FROM rentals WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Rental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_cost"),
                        rs.getString("status")
                );
            }
            return null;
        } finally {
            if (con != null) con.close();
        }
    }
    @Override
    public List<Rental> getAll() throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, car_id, customer_id, start_date, end_date, total_cost, status FROM rentals";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Rental> rentals = new ArrayList<>();
            while (rs.next()) {
                rentals.add(new Rental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_cost"),
                        rs.getString("status")
                ));
            }
            return rentals;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public List<Rental> findByCarId(int carId) throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, car_id, customer_id, start_date, end_date, total_cost, status FROM rentals WHERE car_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, carId);
            ResultSet rs = st.executeQuery();
            List<Rental> rentals = new ArrayList<>();
            while (rs.next()) {
                rentals.add(new Rental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_cost"),
                        rs.getString("status")
                ));
            }
            return rentals;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public List<Rental> findByCustomerId(int customerId) throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, car_id, customer_id, start_date, end_date, total_cost, status FROM rentals WHERE customer_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, customerId);

            ResultSet rs = st.executeQuery();
            List<Rental> rentals = new ArrayList<>();
            while (rs.next()) {
                rentals.add(new Rental(
                        rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getBigDecimal("total_cost"),
                        rs.getString("status")
                ));
            }
            return rentals;
        } finally {
            if (con != null) con.close();
        }
    }

    @Override
    public boolean hasOverlappingRental(int carId, LocalDate startDate, LocalDate endDate) throws SQLException {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT COUNT(*) FROM rentals WHERE car_id=? AND status='active' AND end_date >= ? AND start_date <= ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, carId);
            st.setDate(2, Date.valueOf(startDate));
            st.setDate(3, Date.valueOf(endDate));

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        } finally {
            if (con != null) con.close();
        }
    }
}