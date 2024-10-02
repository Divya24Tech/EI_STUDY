package E-Commerce_Discount_System.main;

import E-Commerce_Discount_System.discount.composite.CompositeDiscount;
import E-Commerce_Discount_System.discount.composite.Discount;
import E-Commerce_Discount_System.discount.composite.SingleDiscount;
import E-Commerce_Discount_System.discount.bridge.DiscountBridge;
import E-Commerce_Discount_System.discount.bridge.LoyaltyDiscount;
import E-Commerce_Discount_System.discount.bridge.SeasonalDiscount;
import E-Commerce_Discount_System.utilities.Logging;

import java.util.Scanner;

public class DiscountApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the original price:");
            double price = Double.parseDouble(scanner.nextLine());

            // Applying individual seasonal discount via Bridge pattern
            DiscountBridge seasonalDiscountBridge = new DiscountBridge(new SeasonalDiscount());
            double priceAfterSeasonalDiscount = seasonalDiscountBridge.apply(price);
            Logging.info("Price after seasonal discount: " + priceAfterSeasonalDiscount);

            // Applying individual loyalty discount via Bridge pattern
            DiscountBridge loyaltyDiscountBridge = new DiscountBridge(new LoyaltyDiscount());
            double priceAfterLoyaltyDiscount = loyaltyDiscountBridge.apply(priceAfterSeasonalDiscount);
            Logging.info("Price after loyalty discount: " + priceAfterLoyaltyDiscount);

            // Using Composite pattern to apply multiple discounts
            CompositeDiscount compositeDiscount = new CompositeDiscount();
            compositeDiscount.addDiscount(new SingleDiscount(10));  // Add 10% discount
            compositeDiscount.addDiscount(new SingleDiscount(5));   // Add 5% discount

            double finalPrice = compositeDiscount.calculate(priceAfterLoyaltyDiscount);
            Logging.info("Final price after applying composite discounts: " + finalPrice);

        } catch (NumberFormatException e) {
            Logging.error("Invalid price input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
