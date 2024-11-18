import java.util.Date;
import java.util.List;

public class Adopcion {
    private Date fecha;

    private Voluntario voluntarioQueTramitaAdopcion;
    private List<Animal> animalesAdoptados;
    private Adoptante adoptante;

    public Adopcion(Date fecha, Voluntario voluntarioQueTramitaAdopcion, List<Animal> animalesAdoptados, Adoptante adoptante){
        assert(fecha != null);
        assert(voluntarioQueTramitaAdopcion != null);

        //Restriccion: Han adoptado al menos un animal del refugio
        assert(animalesAdoptados != null && animalesAdoptados.size() > 1);
        assert(adoptante != null);

        this.fecha = fecha;
        this.voluntarioQueTramitaAdopcion = voluntarioQueTramitaAdopcion;
        this.animalesAdoptados = animalesAdoptados;
        this.adoptante = adoptante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Voluntario getVoluntarioQueTramitaAdopcion() {
        return voluntarioQueTramitaAdopcion;
    }

    public void setVoluntarioQueTramitaAdopcion(Voluntario voluntarioQueTramitaAdopcion) {
        this.voluntarioQueTramitaAdopcion = voluntarioQueTramitaAdopcion;
    }

    public List<Animal> getAnimalesAdoptados() {
        return animalesAdoptados;
    }

    protected void addAnimal(Animal animal){
        animalesAdoptados.add(animal);
    }

    protected void removeAnimal(Animal animal){
        animalesAdoptados.remove(animal);
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
}
