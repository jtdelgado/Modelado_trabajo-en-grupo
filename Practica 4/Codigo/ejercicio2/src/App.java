import java.time.LocalDate;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Crear oficinas de alquiler
        RentalOffice pickUpOffice = new RentalOffice("123 Main St", 50);
        RentalOffice deliveryOffice = new RentalOffice("456 Elm St", 30);

        // Crear coches con diferentes estados
        Model carModel = new Model("Toyota Corolla", 100);
        Car car1 = new Car("1234-ABC", carModel, pickUpOffice, new EnServicio());
        Car car2 = new Car("5678-DEF", carModel, pickUpOffice, new FueraDeServicio(LocalDate.now())); // Fecha ficticia para fuera de servicio

        // Añadir los coches a la oficina de recogida
        pickUpOffice.addCar(car1);
        pickUpOffice.addCar(car2);

        // Mostrar los coches en la oficina de recogida
        System.out.println("Coches en la oficina de recogida:");
        Enumeration<Car> carsInOffice = pickUpOffice.getCars();
        while (carsInOffice.hasMoreElements()) {
            Car car = carsInOffice.nextElement();
            System.out.println("Coche en oficina: " + car.getLicensePlate() + " - Estado: " + car.getEstado().getClass().getSimpleName());
        }

        // Crear un cliente
        Customer customer = new Customer("John Doe", "234R");
        System.out.println("Cliente creado: " + customer.getName() + " - ID: " + customer.getDNI());

        // Intentar alquilar el coche en servicio
        try {
            // Intentar alquilar el coche en servicio
            WebRental webRental1 = new WebRental(LocalDate.now(), LocalDate.now().plusDays(5), customer, car1, pickUpOffice, 15, deliveryOffice);
            pickUpOffice.addRental(webRental1); // Añadimos el alquiler a la oficina
            System.out.println("Alquiler creado con éxito para el coche: " + car1.getLicensePlate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear alquiler para coche " + car1.getLicensePlate() + ": " + e.getMessage());
        }

        // Intentar alquilar el coche fuera de servicio
        try {
            // Intentar alquilar el coche fuera de servicio
            WebRental webRental2 = new WebRental(LocalDate.now(), LocalDate.now().plusDays(5), customer, car2, pickUpOffice, 20, deliveryOffice);
            pickUpOffice.addRental(webRental2); // Añadimos el alquiler a la oficina
            System.out.println("Alquiler creado con éxito para el coche: " + car2.getLicensePlate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear alquiler para coche " + car2.getLicensePlate() + ": " + e.getMessage());
        }

        // Mostrar los alquileres en la oficina de recogida
        System.out.println("\nAlquileres registrados en la oficina de recogida:");
        Enumeration<Rental> rentalsInOffice1 = pickUpOffice.getRentals();
        while (rentalsInOffice1.hasMoreElements()) {
            Rental rental = rentalsInOffice1.nextElement();
            System.out.println("Alquiler: " + rental.getCar().getLicensePlate() + " - Cliente: " + rental.getCustomer().getName());
        }
        System.out.println("\n");

        // Cambiar el estado del coche 2 a "EnServicio"
        car2.setEstado(new EnServicio());
        System.out.println("Estado del coche " + car2.getLicensePlate() + " cambiado a: " + car2.getEstado().getClass().getSimpleName());

        // Intentar alquilar el coche después de cambiar su estado
        try {
            // Intentar alquilar el coche que estaba fuera de servicio
            WebRental webRental3 = new WebRental(LocalDate.now(), LocalDate.now().plusDays(5), customer, car2, pickUpOffice, 10, deliveryOffice);
            pickUpOffice.addRental(webRental3); // Añadimos el alquiler a la oficina
            System.out.println("Alquiler creado con éxito para el coche: " + car2.getLicensePlate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear alquiler para coche " + car2.getLicensePlate() + ": " + e.getMessage());
        }

        // Mostrar los alquileres en la oficina de recogida
        System.out.println("\nAlquileres registrados en la oficina de recogida:");
        Enumeration<Rental> rentalsInOffice2 = pickUpOffice.getRentals();
        while (rentalsInOffice2.hasMoreElements()) {
            Rental rental = rentalsInOffice2.nextElement();
            System.out.println("Alquiler: " + rental.getCar().getLicensePlate() + " - Cliente: " + rental.getCustomer().getName());
        }
    }
}
