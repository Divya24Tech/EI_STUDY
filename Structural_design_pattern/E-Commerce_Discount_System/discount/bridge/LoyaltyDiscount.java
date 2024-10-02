package E-Commerce_Discount_System.discount.bridge;

import E-Commerce_Discount_System.utilities.Logging;

public class LoyaltyDiscount implements DiscountType {

    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.10; // 10% loyalty discount
        Logging.info("Loyalty discount applied: " + discount
