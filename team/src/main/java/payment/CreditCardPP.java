package payment;

public class CreditCardPP implements PaymentInterface {
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardPP(String expiryDate,String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate=expiryDate;
    }
    @Override
    public void processing(paymentMain paymentMain) throws PaymentException {
        validateCard();
        double charge = paymentMain.applyCoupon();
        System.out.printf("Processing credit card payment of $%.2f%n", charge);
        // return this;
    }

    private void validateCard() {
        if (cardNumber == null || cardNumber.length() < 15) {
            throw new PaymentException("Invalid card number.");
        }
        if (expiryDate == null || expiryDate.isBlank()) {
            throw new PaymentException("Card expiry date is missing.");
        }
        if (cvv == null || cvv.length()<3) {
            throw new PaymentException("Invalid CVV code");
        }
    }
}
