import java.time.LocalDate;

public class FueraDeServicio implements EstadoCoche {

    private final LocalDate fechaVueltaServicio;
    
    public FueraDeServicio(LocalDate fechaVueltaServicio) {
        assert fechaVueltaServicio != null : "La fecha de vuelta a servicio no puede ser nula";
        this.fechaVueltaServicio = fechaVueltaServicio;
    }
    
    @Override
    public void takeOutOfService(Car car, LocalDate fechaVueltaServicio) {
        // Si el coche ya está fuera de servicio, no se realiza ninguna acción
        System.out.println("El coche ya está fuera de servicio hasta: " + fechaVueltaServicio);
    }

    @Override
    public boolean isAvailableForRental() {
        return false; // El coche no está disponible para alquiler en este estado
    }

    public LocalDate getFechaVueltaServicio() {
        return fechaVueltaServicio;
    }
}