import java.util.*;

public class PercentagePromotion implements PromotionStrategy{

    private int percentage;
    
	@Override
	public int applyDiscount(int price) {
		return price - (price * percentage / 100);
	}
    public PercentagePromotion(int percentage) {
        this.percentage = percentage;
    }
    
    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
}