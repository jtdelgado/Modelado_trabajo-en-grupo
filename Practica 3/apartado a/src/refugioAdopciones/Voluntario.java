package refugioAdopciones;

import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Voluntario extends Socio {
    private List<Adopcion> tramites ; //Registro de todos los trámites

    public Voluntario(Refugio refugio, Date registro,String nombre) {
        super(refugio, registro,nombre);
        this.tramites= new LinkedList<>(); 
    }

    protected void tramitarAdopcion(Animal animalQueSeAdopta, Adoptante adoptante) {
        // comprobar si el voluntario es del mismo refugio que el animal
        assert (this.getRefugio().equals(animalQueSeAdopta.getRefugio())): "El animal y el voluntario no tienen el mismo refugio";
        //System.out.println(this.getRefugio()+" "+animalQueSeAdopta.getRefugio());

        // comprobar que el animal esta en el refugio
        assert (adoptante.getRefugio().containsAnimal(animalQueSeAdopta)):"El animal no está en el refugio";

        //Comprobar que el animal esta pasado por parametro esta disponible para adopcion
        assert (animalQueSeAdopta.getEstado().equals(EstadoAnimal.disponible)): "El estado del animal no es disponible";

        // El animal se elimina de la lista de animalesRefugiados cuando se adopta
        animalQueSeAdopta.getRefugio().rmAnimalRefugiado(animalQueSeAdopta);

        Date fechaAhora = new Date();
        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalQueSeAdopta, adoptante);

        //El animal pasa a terner estado adoptado
        animalQueSeAdopta.setEstado(EstadoAnimal.adoptado);
    
        tramites.add(nuevaAdopcion);
    }

    protected void registrar(Animal animal) {
        assert ((animal != null )): "El animal es null";

        // Comprobar que el animal no se encuentra en la lista de animalesRefugiados
        // si esta en la lista de animalesRefugiados no esta en la lista de registrados
        assert (this.getRefugio().containsAnimal(animal)): "el animal ya está en la lista de refugiados";

        // Comprbar que el animal no se encuentra en la lista de animalesRegistrados
        assert (this.getRefugio().containsAnimalRegistro(animal)): "el animal ya está en la lista de registrados";

        animal.setEstado(EstadoAnimal.disponible);
        animal.setRefugio(this.getRefugio());

        this.getRefugio().registrar(animal);
    }

    protected Enumeration<Adopcion> getTramites() {
        return Collections.enumeration(tramites);
    }

    protected void rmTramite(Adopcion tramite) {
        tramites.remove(tramite);
    }
}