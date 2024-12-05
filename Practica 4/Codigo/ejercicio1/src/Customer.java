import java.util.*;

public class Customer {
    private String name;
    private String dni;
    private RentalIteratorInterface iterator;

    private List<Rental> rentals; //asociacion Makes

    public Customer(String nombre, String id){
        this.name = nombre;
        this.dni = id;
    }

    public int numberOfRentalsWithDifferentOffices(){
        RentalIterator iterador = new RentalIterator(rentals);
        int count = 0;
        while (iterador.hasNext()) {
            Rental r = iterador.next();

            if(r instanceof WebRental){
                WebRental wr = (WebRental) r;
                if(wr.getPickUpOffice() != wr.getDeliveryOffice()){
                    count++;
                }
            }
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
