import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        RentalOffice alquileresMarta = new RentalOffice("calle etsii", 100);
        Model citroen = new Model("Citroen", 100);
        Car c3 = new Car("666", citroen, alquileresMarta);

        Customer paquito = new Customer("Paquito", "123456789J");

        // Fechas de prueba
        LocalDate startDate = LocalDate.of(2024, 12, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 5);

        // Crear un alquiler sin promoción
        Rental alquiler = new RentalOnSite(startDate, endDate, paquito, c3, alquileresMarta, "Sin comentarios...",
                new NoPromotion());

        System.out.println("Precio sin promoción: " + alquiler.getPrice());

        // Aplicar una promoción de cantidad
        alquiler.setPromotion(new AmountPromotion(30)); // Descuento de 30
        System.out.println("Precio con promoción de cantidad: " + alquiler.getPrice());

        // Aplicar una promoción de porcentaje
        alquiler.setPromotion(new PercentagePromotion(10)); // 10% de descuento
        System.out.println("Precio con promoción de porcentaje: " + alquiler.getPrice());

        // Cambiar la promoción a otra más favorable
        alquiler.setPromotion(new AmountPromotion(100)); // Descuento grande
        System.out.println("Precio con promoción de cantidad más favorable: " + alquiler.getPrice());
    }
}
