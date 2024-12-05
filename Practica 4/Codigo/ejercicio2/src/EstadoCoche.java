import java.time.LocalDate;

public interface EstadoCoche {
    void takeOutOfService(Car car, LocalDate fechaVueltaServicio);
    boolean isAvailableForRental();
}