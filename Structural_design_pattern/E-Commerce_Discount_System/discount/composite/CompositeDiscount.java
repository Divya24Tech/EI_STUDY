package E-Commerce_Discount_System.discount.composite;

import E-Commerce_Discount_System.utilities.Logging;

import java.util.ArrayList;
import java.util.List;

public class CompositeDiscount extends Discount {

    private List<Discount> discounts = new ArrayList<>();

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    @Override
    public double calculate(double price) {
        Logging.info("Applying composite discount...");
        double finalPrice = price;
        for (Discount discount : discounts) {
            finalPrice = discount.calculate(finalPrice);
        }
        return finalPrice;
    }
}
