import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;//asociacion BelongsTo
    private RentalOffice rentalAssigned;//asociacion isAsignedTo
    private List<Rental> rentals; // asociacion isFor1
    //Variables ejercicio 2:
    private EstadoCoche estado; //indica qué estado tiene el coche
    Car cocheSustituto; //variable que se usa para buscar un coche sustituto
    private boolean esSustituto;

    public Car(String licensePlate, Model model,RentalOffice rentalOffice, EstadoCoche estado){
        assert(rentalOffice != null):"RentalOffice no puede ser nulo"; 
        assert(model != null) : "Modelo no puede ser nulo";
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalAssigned= rentalOffice;
        this.estado = estado;
        this.esSustituto = false;
        rentals = new ArrayList<>();
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

    public void takeOutOfService(Date fechaVueltaServicio){
        if (!esSustituto && estado == EstadoCoche.EnServicio) { //un coche sustituto no puede estar fuera de servicio
            estado = EstadoCoche.FueraDeServicio;
            cocheSustituto = buscarCocheSustituto();
        }
    }

    public Car buscarCocheSustituto(){
        Enumeration<Car> cochesEnLaOficina = rentalAssigned.getCars(); // lista de coches
    
        while (cochesEnLaOficina.hasMoreElements()) {
            Car coche = cochesEnLaOficina.nextElement();
    
            // Comprobamos que sea del mismo modelo y que esté en servicio
            if (coche.getModel().equals(this.model) && coche.estado == EstadoCoche.EnServicio) {
                coche.setEsSustituto(true);
                return coche; // Retornamos el primer coche que cumple las condiciones
            }
        }
        // Si no encontramos un coche que cumpla los criterios, retornamos null
        return null;
    }

    public boolean isAvailableForRental() {
        return estado == EstadoCoche.EnServicio;
    }

    public Car getCocheSustituto(){
        return cocheSustituto;
    }

    public void setEstado(EstadoCoche estado){
        this.estado = estado;
    }

    public EstadoCoche getEstado(){
        return estado;
    }

    public void setEsSustituto(boolean esSustituto){
        this.esSustituto = esSustituto;
    }

    public boolean getEsSustituto(){
        return esSustituto;
    }
}
