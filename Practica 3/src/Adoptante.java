import java.util.*;
//Si el animal esta en tratamiento no puede ser adoptado

public class Adoptante extends Socio{
    private List<Adopcion> adopciones= new LinkedList<>();

    public Adoptante (Date registro, Refugio refugio,Animal animal, Voluntario voluntario){
        super(refugio, registro);
        adoptar(animal,voluntario);
    }
    public void adoptar(Animal animal, Voluntario voluntario){
        //assert(animal.getRefugio().l)

    }
    public Enumeration<Adopcion> getAdopciones (){
        return Collections.enumeration(this.adopciones);
    }
    public void removeAdopcion (Adopcion adopcion){
        this.adopciones.remove(adopcion);
    }

    public void addAdopcion (Adopcion adopcion){
        this.adopciones.add(adopcion);
    }
}