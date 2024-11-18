import java.util.*;

public class Donante extends Socio{
    private List<Donacion> donaciones;

    public Donante(Date registro, Refugio refugio){
        super(refugio, registro);
        donaciones = new ArrayList<>();
    }

    public void donar(float cantidadDonada){
        addDonacion(new Donacion(cantidadDonada, new Date(), this));
        getRefugio().setLiquidez(getRefugio().getLiquidez() + cantidadDonada);
    }

    protected void addDonacion(Donacion nuevaDonacion){
        donaciones.add(nuevaDonacion);
    }

    protected void removeDonacion(Donacion donacion){
        donaciones.remove(donacion);
    }

    public List<Donacion> getDonaciones(){
        return this.donaciones;
    }
}