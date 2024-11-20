import java.util.*;
//Si el animal esta en tratamiento no puede ser adoptado

public class Adoptante extends Socio {
    private List<Adopcion> adopciones = new LinkedList<>();

    public Adoptante(Date registro, Refugio refugio, Animal animal, Voluntario voluntario) {
        super(refugio, registro);
        adoptar(animal, voluntario);
    }

    public void adoptar(Animal disponibleParaAdopcion, Voluntario encargadoAdopcion) {
        assert(disponibleParaAdopcion != null);
        assert(encargadoAdopcion != null);

        // La comprobacion de si el animal es del refugio del adoptante
        // y el voluntario esta en el mismo refugio que el animal se hace en el tramitarAdopcion

        encargadoAdopcion.tramitarAdopcion(disponibleParaAdopcion, this);

    }

    public Enumeration<Adopcion> getAdopciones() {
        return Collections.enumeration(this.adopciones);
    }

    public void rmAdopcion(Adopcion adopcion) {
        this.adopciones.remove(adopcion);
    }

    public void addAdopcion(Adopcion adopcion) {
        this.adopciones.add(adopcion);
    }
}