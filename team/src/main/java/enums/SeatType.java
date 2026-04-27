package enums;

public enum SeatType {
    PREMIUM(100.0),
    REGULAR(50.0);

    private double price;

    SeatType(double v) {
        this.price=v;
    }

    public double getPrice() {
        return price;
    }
}
