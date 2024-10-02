package E-Commerce_Discount_System.discount.composite;

import E-Commerce_Discount_System.utilities.Logging;

public class SingleDiscount extends Discount {
    private double discountPercentage;

    public SingleDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculate(double price) {
        double discount = price * discountPercentage / 100;
        Logging.info("Single discount applied: " + discount);
        return price - discount;
    }
}
