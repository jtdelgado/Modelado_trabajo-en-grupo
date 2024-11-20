import java.util.*;


public class Donante extends Socio{
    private List<Donacion> donaciones= new LinkedList<>();

    public Donante(Date registro, Refugio refugio, Donacion donacion){
        super(refugio, registro);
        this.donaciones.add(donacion);
    }

    public void donar(float cantidadDonada){
        addDonacion(new Donacion(cantidadDonada, new Date(), this));
        getRefugio().setLiquidez(getRefugio().getLiquidez() + cantidadDonada);
    }

    protected void addDonacion(Donacion nuevaDonacion){
        donaciones.add(nuevaDonacion);
    }

    protected void rmDonacion(Donacion donacion){
        donaciones.remove(donacion);
    }

    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }
}