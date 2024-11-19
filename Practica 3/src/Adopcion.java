import java.util.Date;

public class Adopcion {
    private Date fecha;

    private Voluntario encargadoAdopcion; // habría que cambiar el nombre del atributo
    // private List<Animal> animalesAdoptados;
    private Adoptante adoptante;
    private Animal animalAdoptado;

    public Adopcion(Date fecha, Voluntario encargadoAdopcion, Animal animalAdoptado, Adoptante adoptante) {
        assert (fecha != null);
        assert (encargadoAdopcion != null);

        assert (animalAdoptado != null);
        assert (adoptante != null);

        this.fecha = fecha;
        this.adoptante = adoptante;
        this.animalAdoptado = animalAdoptado;
        this.encargadoAdopcion = encargadoAdopcion;

        this.animalAdoptado.addAdopcion(this);
        this.adoptante.addAdopcion(this);
    }

    public Date getFecha() {
        return fecha;
    }

    public Voluntario getEncargadoAdopcion() {
        return encargadoAdopcion;
    }

    public Animal getAnimalAdoptado() {
        return animalAdoptado;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    /*
     * En el enunciado no dice que una vez adoptado un animal se pueda cambiar el
     * animal adoptado
     * Además, no tiene sentido
     * 
     * public void setAnimalAdoptado(Animal animal) {
     * this.animalAdoptado.removeAdopcion();
     * this.animalAdoptado = animal;
     * this.animalAdoptado.addAdopcion(this);
     * }
     * 
     * public void setAdoptante(Adoptante adoptante) {
     * this.adoptante.removeAdopcion(this);
     * this.adoptante = adoptante;
     * // Tenemos q transmitar la adopción por parte del voluntario
     * this.adoptante.adoptar(this.animalAdoptado, this.encargadoAdopcion);
     * }
     * 
     * public void setFecha(Date fecha) {
     * this.fecha = fecha;
     * }
     * 
     * public void setEncargadoAdopcion(Voluntario encargadoAdopcion) {
     * this.encargadoAdopcion = encargadoAdopcion;
     * }
     */
}
