import java.time.*;

public class WebRental extends Rental {
    // deliveryTime es [0..1], es decir, puede ser "null"
    private Integer deliveryTime;
    private RentalOffice deliveryOffice; //asociacion delliveryOffice


    public WebRental(LocalDate startDate, LocalDate endDate, Customer customer, Car car, 
                    RentalOffice pickUpOffice, Integer deliveryTime, RentalOffice deliveryOffice) {

        super(startDate,endDate, customer, car, pickUpOffice);

        assert (deliveryOffice != null) : "deliveryOffice no puede ser nulo";


        this.deliveryTime = deliveryTime;
        this.deliveryOffice = deliveryOffice;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public RentalOffice getDeliveryOffice() {
        return deliveryOffice;
    }

    public void setDeliveryOffice(RentalOffice deliveryOffice) {
        assert (deliveryOffice != null) : "deliveryOffice no puede ser nulo";
        this.deliveryOffice = deliveryOffice;
    }
}
