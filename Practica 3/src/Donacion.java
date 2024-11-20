import java.util.Date;

public class Donacion {
    private float cantidad;
    private Date fecha;

    private Donante donante;

    public Donacion(float cantidad, Date fecha, Donante donante){
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.donante = donante;
    }

    public float getCantidad() {
        return cantidad;
    }
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Donante getDonante() {
        return donante;
    }
    public void setDonante(Donante donanteAlQuePertenece) {
        this.donante.rmDonacion(this); // Si queremos cambiar el donante hay que eliminar la donación del anterior

        this.donante = donanteAlQuePertenece;

        this.donante.addDonacion(this);
    }
}