package payment;

import enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class paymentMain {
    private final int transactionID;
    private final double  amount;
    public LocalDateTime paidAt;
    public PaymentStatus status;
    Coupon coupon;

    PaymentInterface processor;


    public paymentMain(int id, double amount) {
        this.transactionID = id;
        this.amount = amount;
        this.status = PaymentStatus.IN_PROCESS;
    }

    public int getTransactionID() {
        return transactionID;
    }
    public double getAmount() {
        return amount;
    }
    public PaymentStatus getStatus() {
        return status;
    }
    public LocalDateTime getPaidAt() {
        return paidAt;
    }
    public Coupon getCoupon() {
        return coupon;
    }

    public double applyCoupon() {
        if (coupon == null) return amount;
        else return coupon.apply(amount);
    }

    public void pay() {
        try {
            processor.processing(this);
            this.status = PaymentStatus.PAID;
            this.paidAt = LocalDateTime.now();
        }
        catch(PaymentException a) {
            this.status= PaymentStatus.FAILED;
            throw a;
        }
    }
}
