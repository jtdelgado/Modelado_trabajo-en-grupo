package refugioAdopciones;
import java.util.*;
//Si el animal esta en tratamiento no puede ser adoptado

public class Adoptante extends Socio {
    private List<Adopcion> adopciones ;

    public Adoptante(Refugio refugio, Date registro,String nombre) {
        super(refugio, registro,nombre);
        this.adopciones= new LinkedList<>();
        // como la relacion es de 0 a muchos entre animal y adoptante,
        // para que exista un adoptante no es necesario que haya adoptado un animal
    }

    public void adoptar(Animal disponibleParaAdopcion, Voluntario encargadoAdopcion) {
        assert(disponibleParaAdopcion != null): "El animal es null";
        assert(encargadoAdopcion != null):"El voluntario encargado es null";

        assert(this.getRefugio().equals(encargadoAdopcion.getRefugio())): "El adoptante y el voluntario no pertenecen al mismo refugio";

        // La comprobacion de si el animal es del refugio del adoptante
        // y el voluntario esta en el mismo refugio que el animal se hace en el tramitarAdopcion

        encargadoAdopcion.tramitarAdopcion(disponibleParaAdopcion, this);

    }

    public Enumeration<Adopcion> getAdopciones() {
        return Collections.enumeration(this.adopciones);
    }

    protected void rmAdopcion(Adopcion adopcion) {
        this.adopciones.remove(adopcion);
    }

    protected  void addAdopcion(Adopcion adopcion) {
        this.adopciones.add(adopcion);
    }
}