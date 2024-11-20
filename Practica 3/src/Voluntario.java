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


        // comprobar que el animal esta en el refugio
        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        boolean estaAnimal = animalesRefugiados.contains(animalQueSeAdopta);

        assert (estaAnimal);

        // comprobar si el voluntario es del mismo refugio que el animal
        assert (this.getRefugio().equals(animalQueSeAdopta.getRefugio()));

        //Comprobar que el animal esta pasado por parametro esta disponible para adopcion
        assert (animalQueSeAdopta.getEstado().equals(EstadoAnimal.disponible));

        Date fechaAhora = new Date();
        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalQueSeAdopta, adoptante);
        
        // El animal se elimina de la lista de animalesRefugiados cuando se adopta
        animalQueSeAdopta.getRefugio().rmAnimalRefugiado(animalQueSeAdopta);
        addTramite(nuevaAdopcion);
    }

    public void registrar(Animal animal) {
        assert (animal != null);

        // Comprobar que el animal no se encuentra en la lista de animalesRefugiados
        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        assert (!animalesRefugiados.contains(animal));

        // Comprbar que el animal no se encuentra en la lista de animalesRegistrados
        List<Animal> animalesRegistrados = Collections.list(this.getRefugio().getAnimalesRegistrados());
        assert (!animalesRegistrados.contains(animal));

        animal.setEstado(EstadoAnimal.disponible);

        this.getRefugio().registrar(animal);
    }

    public Enumeration<Adopcion> getTramites() {
        return Collections.enumeration(tramites);
    }

    protected void addTramite(Adopcion tramite) {
        tramites.add(tramite);
    }

    protected void rmTramite(Adopcion tramite) {
        tramites.remove(tramite);
    }
}