package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private int id;
    private int rentalId;
    private BigDecimal amount;
    private LocalDateTime paymentdate;

    public Payment(){}

    public Payment(int rentalId, BigDecimal amount, LocalDateTime paymentdate) {
        setRentalId(rentalId);
        setAmount(amount);
        setPaymentdate(paymentdate);
    }
    public Payment(int id, int rentalId, BigDecimal amount, LocalDateTime paymentdate) {
        this(rentalId, amount, paymentdate);
        setId(id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRentalId() {
        return rentalId;
    }
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentdate() {
        return paymentdate;
    }
    public void setPaymentdate(LocalDateTime paymentdate) {
        this.paymentdate = paymentdate;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", rentalId=" + rentalId
                + ", amount=" + amount + ", paymentdate=" + paymentdate + '}';
    }

}