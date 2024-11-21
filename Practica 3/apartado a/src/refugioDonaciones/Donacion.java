package refugioDonaciones;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Donacion {
    private float cantidad;
    private Date fecha;

    public Donacion(float cantidad, Date fecha){
        assert (cantidad>=0):"La cantidad a donar debe de ser positiva";
        this.cantidad = cantidad;
        this.fecha = fecha;
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
    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        // Formatear la fecha
        String fechaFormateada = formateador.format(this.fecha);

        
        return this.getClass().getSimpleName()+"=> "+ this.cantidad+" u.m., realizado el "+fechaFormateada;
    }


    
}