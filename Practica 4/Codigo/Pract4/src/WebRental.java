import java.util.*;

public class WebRental {
    // deliveryTime es [0..1], es decir, puede ser "null"
    private int deliveryTime;

    public WebRental(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
