import java.util.*;

public class ConcreteRentalIterator implements RentalIterator {
    private Collection<Rental> rentals;
    private int currentRental =0;

    public ConcreteRentalIterator(Collection<Rental> rentals){

        this.rentals=rentals;
    }

    @Override
    public Rental next() {
        // TODO Auto-generated method stub
        if(this.hasNext()){
            currentRental++;
            return rentals.get(currentRental);
        }
        else{
            // throw new NoSuchElementException();
            return null;
        }

    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return currentRental<rentals.size();
    }

   
    
}
