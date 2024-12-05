import java.util.*;

public abstract class Rental {
    private Date startDate;
    private Date endDate;
    
    private RentalOffice pickUpOffice; //asociacion pickUpOffice
    private Customer customer; //asociacion Makes
    private Car car; //asociacion isFor1

    public Rental(Date startDate, Date endDate, Customer customer, Car car, RentalOffice pickUpOffice){
        assert(customer != null) : "Customer no puede ser nulo";
        assert(car != null) : "Car no puede ser nulo";
        assert(pickUpOffice != null) : "pickUpOffice no puede ser nulo";

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
