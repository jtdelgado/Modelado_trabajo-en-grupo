package refugioDonaciones;
import java.util.*;
import refugioAdopciones.*;


public class Donante extends Rol{
    private List<Donacion> donaciones= new LinkedList<>();

    public Donante(Socio socio){
        super(tipoSocio.donante,socio);
    }

    public void donar(float cantidadDonada){
        assert(cantidadDonada > 0):"Se debe donar una cantidad mayor que 0";

        addDonacion(new Donacion(cantidadDonada, new Date()));
        this.getSocio().getRefugio().setLiquidez(this.getSocio().getRefugio().getLiquidez() + cantidadDonada);
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