import java.util.*;

public class Customer {
    private String name;
    private String dni;
    private RentalIterator iterator;

    private List<Rental> rentals; //asociacion Makes

    public Customer(String nombre, String id){
        this.name = nombre;
        this.dni = id;
    }

    public int numberOfRentalsWithDifferentOffices(){
        ConcreteRentalIterator iterador = new ConcreteRentalIterator(rentals);
        int count = 0;
        while (iterador.hasNext()) {
            iterador.next();
            count++;
        }
        return count;
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
