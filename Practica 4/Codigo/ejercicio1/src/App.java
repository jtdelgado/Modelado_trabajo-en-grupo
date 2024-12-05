import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Customer c1 = new Customer("Pepe", "1");
        
        RentalOffice r1 = new RentalOffice("Oficina 1",20);
        RentalOffice r2 = new RentalOffice("Oficina 2",30);

        Car car1 = new Car("HOLA", new Model("Corolla", 200), r1);

        Car car2 = new Car("ADIOS", new Model("Yaris", 100), r1);

        Car car3 = new Car("HOLA2", new Model("Corolla", 300), r2);

        WebRental w1 = new WebRental(LocalDate.of(2024, 12, 5),
                LocalDate.of(2024, 12, 6), c1, car1, r1, null, r2);

        WebRental w2 = new WebRental(LocalDate.of(2024, 12, 5),
                LocalDate.of(2024, 12, 6), c1, car2, r1, null, r1);
        
        RentalOnSite r3 = new RentalOnSite(LocalDate.of(2024, 12, 7), 
                LocalDate.of(2024, 12, 6), c1, car2, r2, "algo");

        
    
    }

}
