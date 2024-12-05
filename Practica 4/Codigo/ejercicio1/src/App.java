import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Customer c1 = new Customer("Pepe", "1");
        Customer c2 = new Customer("Juan", "2");
        
        RentalOffice r1 = new RentalOffice("Oficina 1",20);
        RentalOffice r2 = new RentalOffice("Oficina 2",30);

        Car car1 = new Car("HOLA", new Model("Corolla", 200), r1);

        Car car2 = new Car("ADIOS", new Model("Yaris", 100), r1);

        Car car3 = new Car("HOLA2", new Model("Corolla", 300), r2);

        // Este WebRental tiene oficina de recogida y entrega diferentes
        WebRental w1 = new WebRental(LocalDate.of(2024, 12, 5),
                LocalDate.of(2024, 12, 6), c1, car1, r1, null, r2);

        // Este WebRental tiene oficina de recogida y entrega iguales
        WebRental w2 = new WebRental(LocalDate.of(2024, 12, 5),
                LocalDate.of(2024, 12, 6), c1, car2, r1, null, r1);
        
        RentalOnSite r3 = new RentalOnSite(LocalDate.of(2024, 12, 7), 
                LocalDate.of(2024, 12, 6), c1, car3, r2, "algo");

        // Añado un alquiler web al cliente1 que tiene diferente oficina de recogida y entrega
        // y otro alquiler web al cliente1 que tiene la misma oficina de recogida y entrega
        c1.addRental(w1);
        c1.addRental(w2);

        // Añado un alquiler onSite al cliente2
        c2.addRental(r3);

        System.out.println("\nEl numero de alquileres con diferentes oficinas de recogida del cliente " +
                        c1.getName()+ " y entrega es: " + c1.numberOfRentalsWithDifferentOffices());

        System.out.println("El numero de alquileres con diferentes oficinas de recogida del cliente " +
                        c2.getName()+ " y entrega es: " + c2.numberOfRentalsWithDifferentOffices());        
    
    }

}
