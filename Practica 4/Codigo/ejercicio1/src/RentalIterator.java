import java.util.*;

public class RentalIterator implements RentalIteratorInterface {
    private Collection<Rental> rentals;
    private Iterator<Rental> iterator;

    public RentalIterator(Collection<Rental> rentals){
        this.iterator = rentals.iterator();
    }

    @Override
    public Rental next() {
        if(iterator.hasNext()){
            return iterator.next();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

   
    
}
