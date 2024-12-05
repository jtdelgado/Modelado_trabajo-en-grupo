import java.time.LocalDate;
import java.util.*;

public class Car {
    private String licensePlate;
    private Model model;//asociacion BelongsTo
    private RentalOffice rentalAssigned;//asociacion isAsignedTo
    private final List<Rental> rentals; // asociacion isFor1

    //Variables ejercicio 2:
    private EstadoCoche estado; 
    //indica qué estado tiene el coche (variable que se inicializa con el tipo 
    //de la clase interfaz EstadoCoche para que pueda ser usada como EnServicio 
    //y como FueraDeServicio indistintamente)
    Car cocheSustituto; //variable que se usa para buscar un coche sustituto
    private boolean esSustituto; //indica si el coche es un coche sustituto

    public Car(String licensePlate, Model model, RentalOffice rentalOffice, EstadoCoche estadoCoche) {
        assert (rentalOffice != null) : "RentalOffice no puede ser nulo";
        assert (model != null) : "Modelo no puede ser nulo";
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalAssigned = rentalOffice;
        this.estado = estadoCoche; // Se inicializa con un estado concreto
        this.esSustituto = false;
        this.rentals = new ArrayList<>();
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
        assert (model != null) : "Modelo no puede ser nulo";
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

    public void takeOutOfService(LocalDate fechaVueltaServicio) {
        estado.takeOutOfService(this, fechaVueltaServicio);
    }

    public Car buscarCocheSustituto(){
        Enumeration<Car> cochesEnLaOficina = rentalAssigned.getCars(); // lista de coches
    
        while (cochesEnLaOficina.hasMoreElements()) {
            Car coche = cochesEnLaOficina.nextElement();
    
            // Comprobamos que sea del mismo modelo y que esté en servicio
            if (coche.getModel().equals(this.model) && coche.estado.isAvailableForRental()) {
                coche.setEsSustituto(true);
                return coche; // Retornamos el primer coche que cumple las condiciones
            }
        }
        // Si no encontramos un coche que cumpla los criterios, retornamos null
        return null;
    }

    //Getters y Setters ejercicio 2:

    public Car getCocheSustituto(){
        return cocheSustituto;
    }
    
    public void setCocheSustituto(Car cocheSustituto) {
        this.cocheSustituto = cocheSustituto;
    }

    public EstadoCoche getEstado(){
        return estado;
    }

    public void setEstado(EstadoCoche estado){
        this.estado = estado;
    }

    public boolean getEsSustituto(){
        return esSustituto;
    }

    public void setEsSustituto(boolean esSustituto){
        this.esSustituto = esSustituto;
    }
}
