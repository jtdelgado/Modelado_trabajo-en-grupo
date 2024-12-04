import java.util.*;

public class Customer {
    private String name;
    private String dni;
    private List<Rental> rentals; // asociacion Makes

    public Customer(String nombre, String id) {
        this.name = nombre;
        this.dni = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String d) {
        this.dni = d;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public Enumeration<Rental> getRentals() {
        return Collections.enumeration(this.rentals);
    }

}
