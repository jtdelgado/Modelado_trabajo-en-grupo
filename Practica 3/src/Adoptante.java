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

        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        boolean estaAnimal = animalesRefugiados.contains(disponibleParaAdopcion);

        assert (estaAnimal);

        // comprobar si el encargadoAdopcion es del mismo refugio que el animal
        assert (encargadoAdopcion.getRefugio().equals(disponibleParaAdopcion.getRefugio()));

        encargadoAdopcion.tramitarAdopcion(disponibleParaAdopcion, this);

    }

    public Enumeration<Adopcion> getAdopciones() {
        return Collections.enumeration(this.adopciones);
    }

    public void removeAdopcion(Adopcion adopcion) {
        this.adopciones.remove(adopcion);
    }

    public void addAdopcion(Adopcion adopcion) {
        this.adopciones.add(adopcion);
    }
}