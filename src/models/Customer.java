package models;

import java.time.LocalDate;
import java.time.Period;

public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String driverLicenseId;
    private LocalDate birthdate;

    public Customer(){}

    public Customer(String fullName, String email, String driverLicenseId, LocalDate birthdate) {
        setFullName(fullName);
        setEmail(email);
        setDriverLicenseId(driverLicenseId);
        setBirthdate(birthdate);
    }

    public Customer(int id, String fullName, String email, String driverLicenseId, LocalDate birthdate) {
        this(fullName, email, driverLicenseId, birthdate);
        setId(id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicenseId() {
        return driverLicenseId;
    }
    public void setDriverLicenseId(String driverLicenseId) {
        this.driverLicenseId = driverLicenseId;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fullName=" + fullName
                + ", email=" + email + ", driverLicenseId=" + driverLicenseId
                + ", age" + getAge()+ '}';
    }
}