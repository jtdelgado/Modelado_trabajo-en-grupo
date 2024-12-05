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
        Car car2 = new Car("5678-DEF", carModel, pickUpOffice, new EnServicio());
        Car car3 = new Car("1111-XYZ", carModel, pickUpOffice, new EnServicio());

        // Añadir los coches a la oficina de recogida
        pickUpOffice.addCar(car1);
        pickUpOffice.addCar(car2);
        pickUpOffice.addCar(car3);

        // Mostrar los coches en la oficina de recogida antes de tomar fuera de servicio
        System.out.println("Coches en la oficina de recogida antes de tomar fuera de servicio:");
        Enumeration<Car> carsInOffice = pickUpOffice.getCars();
        while (carsInOffice.hasMoreElements()) {
            Car car = carsInOffice.nextElement();
            System.out.println("Coche en oficina: " + car.getLicensePlate() + " - Estado: " + car.getEstado().getClass().getSimpleName());
        }

        // Crear un cliente
        Customer customer = new Customer("John Doe", "234R");
        System.out.println("Cliente creado: " + customer.getName() + " - ID: " + customer.getDNI());

        // Probar el método takeOutOfService en el coche 1
        System.out.println("\nPoniendo el coche " + car1.getLicensePlate() + " fuera de servicio...");
        car1.takeOutOfService(LocalDate.now().plusDays(7));  // El coche estará fuera de servicio por 7 días

        // Mostrar el estado del coche después de ponerlo fuera de servicio
        System.out.println("Estado del coche " + car1.getLicensePlate() + " después de ponerlo fuera de servicio: " + car1.getEstado().getClass().getSimpleName());

        // Intentar alquilar el coche 1 después de ponerlo fuera de servicio (no debe estar disponible)
        try {
            WebRental webRental1 = new WebRental(LocalDate.now(), LocalDate.now().plusDays(5), customer, car1, pickUpOffice, 15, deliveryOffice);
            pickUpOffice.addRental(webRental1); // Añadimos el alquiler a la oficina
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear alquiler para coche " + car1.getLicensePlate() + ": No hay coches disponibles");
        }

        // Comprobar si se ha asignado un coche sustituto
        Car cocheSustituto = car1.getCocheSustituto();
        if (cocheSustituto != null) {
            System.out.println("Coche sustituto encontrado: " + cocheSustituto.getLicensePlate());
        } else {
            System.out.println("No se ha encontrado coche sustituto para el coche " + car1.getLicensePlate());
        }

        // Probar que el coche 2 sea el sustituto de car1 (y que car2 esté disponible para alquiler)
        System.out.println("\nComprobando si el coche 2 es un coche sustituto de " + car1.getLicensePlate());
        if (car2.getEstado().isAvailableForRental()) {
            System.out.println("Coche 2 es sustituto.");
        } else {
            System.out.println("Coche 2 NO es sustituto.");
        }

        // Ahora, volver a poner el coche 1 en servicio
        System.out.println("\nPoniendo el coche " + car1.getLicensePlate() + " de vuelta en servicio...");
        car1.setEstado(new EnServicio());

        // Mostrar el estado después de devolverlo a servicio
        System.out.println("Estado del coche " + car1.getLicensePlate() + " después de ponerlo en servicio: " + car1.getEstado().getClass().getSimpleName());

        // Intentar alquilar el coche 1 ahora que está en servicio
        try {
            WebRental webRental2 = new WebRental(LocalDate.now(), LocalDate.now().plusDays(5), customer, car1, pickUpOffice, 10, deliveryOffice);
            pickUpOffice.addRental(webRental2); // Añadimos el alquiler a la oficina
            System.out.println("Alquiler creado con éxito para el coche: " + car1.getLicensePlate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear alquiler para coche " + car1.getLicensePlate() + ": " + e.getMessage());
        }

        // Mostrar los alquileres registrados
        System.out.println("\nAlquileres registrados en la oficina de recogida:");
        Enumeration<Rental> rentalsInOffice = pickUpOffice.getRentals();
        while (rentalsInOffice.hasMoreElements()) {
            Rental rental = rentalsInOffice.nextElement();
            System.out.println("Alquiler: " + rental.getCar().getLicensePlate() + " - Cliente: " + rental.getCustomer().getName());
        }
    }
}
