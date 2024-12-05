import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Rental {
    private LocalDate startDate;
    private LocalDate endDate;

    private RentalOffice pickUpOffice; // asociacion pickUpOffice
    private Customer customer; // asociacion Makes
    private Car car; // asociacion isFor1
    private PromotionStrategy promotion;

    public Rental(LocalDate startDate, LocalDate endDate, Customer customer, Car car, RentalOffice pickUpOffice,
            PromotionStrategy promotion) {
        assert(customer != null) : "Customer no puede ser nulo";
        assert(car != null) : "Car no puede ser nulo";
        assert(pickUpOffice != null) : "pickUpOffice no puede ser nulo";
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.pickUpOffice = pickUpOffice;
        this.promotion = promotion;
    }

    public int getPrice() {
        // Calculate the number of rental days
        long rentalDays = ChronoUnit.DAYS.between(startDate, endDate);
        int basePrice = (int) (car.getModel().getPricePerDay() * rentalDays);

        // Apply promotion
        return promotion.applyDiscount(basePrice);
    }

    // Permitir actualizar la promoción
    public void setPromotion(PromotionStrategy promotion) {
        this.promotion = promotion;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer c) {
        assert(customer != null) : "Customer no puede ser nulo";
        this.customer =  c;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        assert(car != null) : "Car no puede ser nulo";
        this.car = car;
    }

    public RentalOffice getPickUpOffice() {
        return pickUpOffice;
    }

    public void setPickUpOffice(RentalOffice pickUpOffice) {
        assert(pickUpOffice != null) : "pickUpOffice no puede ser nulo";
        this.pickUpOffice= pickUpOffice;
    }

}
