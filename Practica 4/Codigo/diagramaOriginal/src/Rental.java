import java.time.LocalDate;
import java.util.*;

public abstract class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    
    private RentalOffice pickUpOffice; //asociacion pickUpOffice
    private Customer customer; //asociacion Makes
    private Car car; //asociacion isFor1

    public Rental(LocalDate startDate, LocalDate endDate, Customer customer, Car car, RentalOffice pickUpOffice){
        if(!FechasValidas(startDate,endDate)) 
            // throw new Exception("Error: el formato de las fechas es inválido.");
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.car = car;
        this.pickUpOffice = pickUpOffice;
    }

    public boolean FechasValidas(LocalDate starDate,LocalDate endDate){
        boolean valido = true;
        if((starDate== null || endDate== null) && starDate.isAfter(endDate)) valido= false;
        return valido;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        if(FechasValidas(startDate,this.endDate))this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate){
        if(FechasValidas(this.startDate,endDate))this.endDate = endDate;
        //else 
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

    public void setPickUpOffice(RentalOffice pickUpOffice){
        this.pickUpOffice = pickUpOffice;
    }
    
}
