import java.time.LocalDate;
import java.util.*;

public class WebRental extends Rental {
    // deliveryTime es [0..1], es decir, puede ser "null"
    private int deliveryTime;
    private RentalOffice deliveryOffice; // asociacion delliveryOffice

    public WebRental(LocalDate startDate, LocalDate endDate, Customer customer, Car car,
            RentalOffice pickUpOffice, int deliveryTime, RentalOffice deliveryOffice, PromotionStrategy promotion) {

        super(startDate, endDate, customer, car, pickUpOffice, promotion);
        this.deliveryTime = deliveryTime;
        this.deliveryOffice = deliveryOffice;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        this.deliveryOffice = deliveryOffice;
    }
}
