import java.util.*;

public class NoPromotion implements PromotionStrategy{

	@Override
	public int applyDiscount(int price) {
		return price;
	}
    
}