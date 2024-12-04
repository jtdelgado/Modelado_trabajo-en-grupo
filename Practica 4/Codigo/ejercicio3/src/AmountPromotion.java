import java.util.*;

public class AmountPromotion implements PromotionStrategy {

    private int amount;

    @Override
    public int applyDiscount(int price) {
        return price - amount;
    }

    public AmountPromotion(int amount) {
        this.amount = amount;
    }
    
    public int getAmountPromotion() {
        return amount;
    }

    public void setAmountPromotion(int amount) {
        this.amount = amount;
    }

}