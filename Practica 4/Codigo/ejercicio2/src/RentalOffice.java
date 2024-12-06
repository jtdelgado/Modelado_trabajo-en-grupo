import java.util.*;

public class RentalOffice{
    private String address;
    private int feeForDelivery;
    
    private List<Car> cars;//asociacion isAssignedTo
    private List<WebRental> webRentals; // asociacion deliveryOffice
    private List<Rental> rentals; // asociacion pickUpOffice

    public RentalOffice(String address, int feeForDelivery){
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        cars = new ArrayList<>();
        webRentals = new ArrayList<>();
        rentals = new ArrayList<>();
    
    }

    public int getfeeForDelivery(){
        return feeForDelivery;
    }
    public String getaddress(){
        return address;
    }

    public void setFeeForDelivery(int feeForDelivery){
        this.feeForDelivery = feeForDelivery;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Enumeration<Car> getCars(){
        return Collections.enumeration(cars);
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public Enumeration<WebRental> getWebRentals(){
        return Collections.enumeration(webRentals);
    }

    public void addWebRental(WebRental webRental){
        webRentals.add(webRental);
    }

    public void removeWebRental(WebRental webRental){
        webRentals.remove(webRental);
    }

    public Enumeration<Rental> getRentals(){
        return Collections.enumeration(this.rentals);
    }  
     
    public void addRental(Rental rental){
        Car car = rental.getCar();
        if (car.isAvailableForRental()) {
            rentals.add(rental);
        } else {
            System.out.println("El coche seleccionado no está disponible actualmente, procedemos a buscar un coche sustituto");
            Car carSustituto = car.getCocheSustituto();
            if (carSustituto == null) {
                throw new IllegalArgumentException("No hay coches disponibles");
            }
            rental.setCar(carSustituto);
            rentals.add(rental);
        }
    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    

}