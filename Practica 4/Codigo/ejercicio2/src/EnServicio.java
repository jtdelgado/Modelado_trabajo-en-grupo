import java.time.LocalDate;

public class EnServicio implements EstadoCoche {

    public EnServicio() {
        // Constructor vacío: no se necesita configuración específica
    }

    @Override
    public void takeOutOfService(Car car, LocalDate fechaVueltaServicio) {
        if (!car.getEsSustituto()) { // Un coche sustituto no puede ponerse fuera de servicio
            car.setEstado(new FueraDeServicio(fechaVueltaServicio)); // Cambiar estado
            Car cocheSustituto = car.buscarCocheSustituto(); // Buscar sustituto
            car.setCocheSustituto(cocheSustituto); // Asignar coche sustituto si se encuentra
        }
    }

    @Override
    public boolean isAvailableForRental() {
        return true; // El coche está disponible para alquiler en este estado
    }
}