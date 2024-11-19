//Clase y sus relaciones terminadas :)

import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Voluntario extends Socio {
    private List<Adopcion> tramites = new LinkedList<>();

    public Voluntario(Refugio refugio, Date registro) {
        super(refugio, registro);
    }

    public void tramitarAdopcion(Animal animalQueSeAdopta, Adoptante adoptante) {
        assert (animalQueSeAdopta != null);
        assert (adoptante != null);

        Date fechaAhora = new Date();
        // List<Animal> animalesAdoptados = List.of(animalQueSeAdopta);
        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalQueSeAdopta, adoptante);

        addTramite(nuevaAdopcion);
    }

    public void registrar(Animal animal) {
        assert (animal != null);

        // Comprobar que el animal se encuentra en el refugio
        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        assert (animalesRefugiados.contains(animal));

        this.getRefugio().registrar(animal);
    }

    public Enumeration<Adopcion> getTramites() {
        return Collections.enumeration(tramites);
    }

    protected void addTramite(Adopcion tramite) {
        tramites.add(tramite);
    }

    protected void removeTramite(Adopcion tramite) {
        tramites.remove(tramite);
    }
}