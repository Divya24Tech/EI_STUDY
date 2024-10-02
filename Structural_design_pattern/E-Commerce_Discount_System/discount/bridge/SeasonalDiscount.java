package E-Commerce_Discount_System.discount.bridge;

import E-Commerce_Discount_System.utilities.Logging;

public class SeasonalDiscount implements DiscountType {

    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.15; // 15% seasonal discount
        Logging.info("Seasonal discount applied: " + discount);
        return price - discount;
    }
}
