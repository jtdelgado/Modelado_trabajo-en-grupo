import java.util.Date;
import java.util.*;
//Si el animal esta en tratamiento no puede ser adoptado

public class Adoptante extends Socio{
    private List<Adopcion> adopciones;

    public Adoptante (Date registro, Refugio refugio,Animal animal){
        super(refugio, registro);
        adoptar(animal);
    }
    public void adoptar(Animal animal){
        assert(animal.getRefugio().l)
    }     
}