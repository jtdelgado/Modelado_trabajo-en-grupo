import java.time.LocalDate;
import java.util.*;

public abstract class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    
    private RentalOffice pickUpOffice; //asociacion pickUpOffice
    private Customer customer; //asociacion Makes
    private Car car; //asociacion isFor1

    public Rental(LocalDate startDate, LocalDate endDate, Customer customer, Car car, RentalOffice pickUpOffice){
        assert(customer != null) : "Customer no puede ser nulo";
        assert(car != null) : "Car no puede ser nulo";
        assert(pickUpOffice != null) : "pickUpOffice no puede ser nulo";

        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.pickUpOffice = pickUpOffice;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        assert(customer != null) : "Customer no puede ser nulo";
         this.customer= customer;
    }

    public Car getCar(){
        return car;
    }

    public void setCar(Car car){
        assert(car != null) : "Car no puede ser nulo";
        this.car = car;
    }

    public RentalOffice getPickUpOffice(){
        return pickUpOffice;
    }

    public void setPickUpOffice(RentalOffice pickOffice){
        assert(pickUpOffice != null) : "pickUpOffice no puede ser nulo";
        this.pickUpOffice= pickOffice;
    }
    
}
