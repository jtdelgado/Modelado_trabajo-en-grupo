import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;//asociacion BelongsTo
    private RentalOffice rentalAssigned;//asociacion isAsignedTo
    private List<Rental> rentals; // asociacion isFor1

    public Car(String licensePlate, Model model,RentalOffice rentalOffice) {
        assert(rentalOffice != null):"Error: la oficina de alquiler no puede ser nula.";

        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalAssigned= rentalOffice;
        this.rentals = new ArrayList<Rental>();
    }

    public boolean mismaOficinaAsignadoYAlquiler(){
        if(this.rentals.isEmpty()) return true;

        return this.rentals.getLast().getPickUpOffice().equals(this.rentalAssigned);
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
        this.model = model;
    }

    public RentalOffice getrentalAssigned(){
        return rentalAssigned;
    }

    public void setrentalAssigned(RentalOffice rentalOffice){
        this.rentalAssigned = rentalOffice;
    }

    public void addRental(Rental rental){

        //Compruebo que si el ultimo alquiler en la lista es webRental, 
        // el pickUpOffice del nuevo alquiler sea igual al deliveryOffice del ultimo alquiler
        // y la oficina del coche sea igual a la la oficina 
        if(!rentals.isEmpty() && rentals.getLast() instanceof WebRental){
            WebRental webRental = (WebRental) rentals.getLast();

            rental.setPickUpOffice(webRental.getDeliveryOffice());

            this.rentalAssigned = webRental.getDeliveryOffice();

        }
        else if(mismaOficinaAsignadoYAlquiler()){
            rentals.add(rental);
        }
    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    public Enumeration<Rental> getRentals(){
        return Collections.enumeration(this.rentals);
    }

   
}
