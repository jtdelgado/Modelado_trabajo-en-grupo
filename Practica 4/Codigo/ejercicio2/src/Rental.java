import java.util.*;

public abstract class Rental {
    private Date startDate;
    private Date endDate;
    
    private RentalOffice pickUpOffice; //asociacion pickUpOffice
    private Customer customer; //asociacion Makes
    private Car car; //asociacion isFor1

    public Rental(Date startDate, Date endDate, Customer customer, Car car, RentalOffice pickUpOffice){
        if (!car.isAvailableForRental()) {
            this.car = car.getCocheSustituto();
            if (this.car == null) {
                throw new IllegalArgumentException("No hay coches disponibles");
            }
        }
        
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.pickUpOffice = pickUpOffice;
    }

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Customer setCustomer(){
        return customer;
    }

    public Car getCar(){
        return car;
    }

    public Car setCar(){
        return car;
    }

    public RentalOffice getPickUpOffice(){
        return pickUpOffice;
    }

    public RentalOffice setPickUpOffice(){
        return pickUpOffice;
    }
    
}
