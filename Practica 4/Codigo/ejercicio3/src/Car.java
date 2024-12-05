import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;//asociacion BelongsTo
    private RentalOffice rentalAssigned;//asociacion isAsignedTo
    private List<Rental> rentals; // asociacion isFor1

    public Car(String licensePlate, Model model,RentalOffice rentalOffice) {
        assert(rentalOffice != null):"RentalOffice no puede ser nulo"; 
        assert(model != null) : "Modelo no puede ser nulo";
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalAssigned= rentalOffice;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        assert(model != null) : "Modelo no puede ser nulo";
        this.model = model;
    }

    public RentalOffice getrentalAssigned(){
        return rentalAssigned;
    }

    public void setrentalAssigned(RentalOffice rentalOffice){
        assert(rentalOffice != null):"RentalOffice no puede ser nulo"; 
        this.rentalAssigned = rentalOffice;
    }

    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    public Enumeration<Rental> getRentals(){
        return Collections.enumeration(this.rentals);
    }

   
}
