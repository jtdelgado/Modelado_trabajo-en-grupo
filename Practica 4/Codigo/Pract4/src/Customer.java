import java.util.*;

public class Customer {
    private String name;
    private String dni;
    private RentalIterator iterator;
    private Collection<Rental> rentals;

    public Customer(String nombre, String id){
        this.name = nombre;
        this.dni = id;
    }

    public int numberOfRentalsWithDifferentOffices(){
        ConcreteRentalIterator iterador = new ConcreteRentalIterator(rentals);
        int count = 0;
        while (iterador.hasNext()) {
            Rental alquiler = iterador.next();
            count++;
        }
        return count;
    }

    //public Rental getRental(int i){
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
}
