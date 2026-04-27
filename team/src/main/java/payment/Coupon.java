package payment;

import java.time.LocalDate;

public class Coupon {
    private final int ID;
    private final double balance;
    private final LocalDate expiryDate;

    public Coupon(int id, double balance, LocalDate expiryDate) {
        ID = id;
        this.balance = balance;
        this.expiryDate = expiryDate;
    }
    public double apply(double price) {
        if (LocalDate.now().isAfter(expiryDate)) {
            throw new PaymentException("Coupon '" + ID + "' has expired.");
        }
        else return Math.max(0,price - balance );
    }
    public int getID(){
        return ID;
    }
    public double getBalance()  {
        return balance;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
