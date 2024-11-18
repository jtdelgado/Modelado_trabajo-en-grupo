//Clase y sus relaciones terminadas :)

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Voluntario extends Socio{
    private List<Adopcion> tramites;

    public Voluntario(Refugio refugio, Date registro) {
        super(refugio, registro);
        tramites = new ArrayList<>();
    }

    public void tramitarAdopcion(Animal animalQueSeAdopta, Adoptante adoptante){
        assert(animalQueSeAdopta != null);
        assert(adoptante != null);

        Date fechaAhora = new Date();
        List<Animal> animalesAdoptados = List.of(animalQueSeAdopta);
        Adopcion nuevaAdopcion = new Adopcion(fechaAhora, this, animalesAdoptados, adoptante);

        addTramite(nuevaAdopcion);
    }

    public void registrar(Animal animal, Refugio refugio){
        assert(animal != null);
        assert(refugio != null);

        refugio.registrar(animal);
    }

    public List<Adopcion> getTramites() {
        return tramites;
    }

    protected void addTramite(Adopcion tramite){
        tramites.add(tramite);
    }

    protected void removeTramite(Adopcion tramite){
        tramites.remove(tramite);
    }
}