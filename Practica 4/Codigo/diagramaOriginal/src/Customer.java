import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Customer {
    private String name;
    private String dni;

    private List<Rental> rentals; //asociacion Makes

    public Customer(String nombre, String id){
        this.name = nombre;
        this.dni = id;
        this.rentals = new ArrayList<Rental>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getDNI(){
        return dni;
    }

    public void setDNI(String d){
        this.dni = d;
    }

    // dateStart1 = 11/10
    // dateEnd1 = 21/10

    // dateStart2 = 16/10
    // dateEnd2 = 20/10
    public void addRental(Rental rental){
        for (Rental r : rentals) {
            if(r.getEndDate().isBefore(rental.getStartDate()) 
                        || rental.getEndDate().isBefore(rental.getStartDate())){

                rentals.add(rental);
            }
            else{
                assert(false):"Error: la fecha de inicio o fin de la renta se superpone con otra renta.";
            }
        }

    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    public Enumeration<Rental> getRentals(){
        return Collections.enumeration(this.rentals);
    }

}
