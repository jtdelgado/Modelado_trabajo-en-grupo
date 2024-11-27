package refugioAdopciones;

import java.util.*;

public class Voluntario extends Rol {
    private List<Adopcion> tramites;

    public Voluntario(Socio socio) {
        super(tipoSocio.voluntario, socio);
        
        this.tramites = new LinkedList<>();
    }

    protected void tramitarAdopcion(Animal animalQueSeAdopta, Socio adoptante) {
        // comprobar si el voluntario es del mismo refugio que el animal
        assert (this.getSocio().getRefugio().equals(animalQueSeAdopta.getRefugio())): "El voluntario y el animal no tienen el mismo refugio";

        // comprobar que el animal esta en el refugio
        List<Animal> animalesRefugiados = Collections.list(this.getSocio().getRefugio().getAnimalesRefugiados());
        boolean estaAnimal = animalesRefugiados.contains(animalQueSeAdopta);

        assert (estaAnimal):"El animal no está en el refugio";

        //Comprobar que el animal esta pasado por parametro esta disponible para adopcion
        assert (animalQueSeAdopta.getEstado().equals(EstadoAnimal.disponible)): "El estado del animal no es disponible";

        // El animal se elimina de la lista de animalesRefugiados cuando se adopta
        animalQueSeAdopta.getRefugio().rmAnimalRefugiado(animalQueSeAdopta);

        Date fechaAhora = new Date();

        Adoptante adop = (Adoptante)adoptante.getRol(tipoSocio.adoptante);

        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalQueSeAdopta, adop);

        //El animal pasa a terner estado adoptado
        animalQueSeAdopta.setEstado(EstadoAnimal.adoptado);
    
        tramites.add(nuevaAdopcion);
    }

    protected void registrar(Animal animal) {
        assert ((animal != null )): "El animal es null";

        // Comprobar que el animal no se encuentra en la lista de animalesRefugiados
        // si esta en la lista de animalesRefugiados no esta en la lista de registrados
        List<Animal> animalesRefugiados = Collections.list(this.getSocio().getRefugio().getAnimalesRefugiados());
        assert (!animalesRefugiados.contains(animal)): "el animal ya está en la lista de refugiados";

        // Comprbar que el animal no se encuentra en la lista de animalesRegistrados
        List<Animal> animalesRegistrados = Collections.list(this.getSocio().getRefugio().getAnimalesRegistrados());
        assert (!animalesRegistrados.contains(animal)): "el animal ya está en la lista de registrados";

        animal.setEstado(EstadoAnimal.disponible);
        animal.setRefugio(this.getSocio().getRefugio());

        this.getSocio().getRefugio().registrar(animal);
    }

    protected Enumeration<Adopcion> getTramites() {
        return Collections.enumeration(tramites);
    }

    // no hay un add tramite porque el tramite se crea en el metodo tramitarAdopcion

    protected void rmTramite(Adopcion tramite) {
        tramites.remove(tramite);
    }
}