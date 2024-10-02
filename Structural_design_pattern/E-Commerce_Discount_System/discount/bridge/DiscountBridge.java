package E-Commerce_Discount_System.discount.bridge;

public class DiscountBridge {
    protected DiscountType discountType;

    public DiscountBridge(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double apply(double price) {
        return discountType.applyDiscount(price);
    }
}
