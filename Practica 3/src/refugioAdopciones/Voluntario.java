package refugioAdopciones;

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

    protected void tramitarAdopcion(Animal animalQueSeAdopta, Adoptante adoptante) {
        // comprobar si el voluntario es del mismo refugio que el animal
        assert (this.getRefugio().equals(animalQueSeAdopta.getRefugio()));

        // comprobar que el animal esta en el refugio
        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        boolean estaAnimal = animalesRefugiados.contains(animalQueSeAdopta);

        assert (estaAnimal);

        //Comprobar que el animal esta pasado por parametro esta disponible para adopcion
        assert (animalQueSeAdopta.getEstado().equals(EstadoAnimal.disponible));

        // El animal se elimina de la lista de animalesRefugiados cuando se adopta
        animalQueSeAdopta.getRefugio().rmAnimalRefugiado(animalQueSeAdopta);

        Date fechaAhora = new Date();
        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalQueSeAdopta, adoptante);

        //El animal pasa a terner estado adoptado
        animalQueSeAdopta.setEstado(EstadoAnimal.adoptado);
    
        tramites.add(nuevaAdopcion);
    }

    protected void registrar(Animal animal) {
        assert (animal != null);

        // Comprobar que el animal no se encuentra en la lista de animalesRefugiados
        // si esta en la lista de animalesRefugiados no esta en la lista de registrados
        List<Animal> animalesRefugiados = Collections.list(this.getRefugio().getAnimalesRefugiados());
        assert (!animalesRefugiados.contains(animal));

        // Comprbar que el animal no se encuentra en la lista de animalesRegistrados
        List<Animal> animalesRegistrados = Collections.list(this.getRefugio().getAnimalesRegistrados());
        assert (!animalesRegistrados.contains(animal));

        animal.setEstado(EstadoAnimal.disponible);
        animal.setRefugio(this.getRefugio());

        this.getRefugio().registrar(animal);
    }

    protected Enumeration<Adopcion> getTramites() {
        return Collections.enumeration(tramites);
    }

    // no hay un add tramite porque el tramite se crea en el metodo tramitarAdopcion

    protected void rmTramite(Adopcion tramite) {
        tramites.remove(tramite);
    }
}