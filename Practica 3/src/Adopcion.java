import java.util.Date;

public class Adopcion {
    private Date fecha;

    private Voluntario voluntarioQueTramitaAdopcion; //habría que cambiar el nombre del atributo
    //private List<Animal> animalesAdoptados;
    private Adoptante adoptante;
    private Animal animalAdoptado;

    // public Adopcion(Date fecha, Voluntario voluntarioQueTramitaAdopcion, List<Animal> animalesAdoptados, Adoptante adoptante){
    //     assert(fecha != null);
    //     assert(voluntarioQueTramitaAdopcion != null);

    //     //Restriccion: Han adoptado al menos un animal del refugio
    //     assert(animalesAdoptados != null && animalesAdoptados.size() > 1);
    //     assert(adoptante != null);

    //     this.fecha = fecha;
    //     this.voluntarioQueTramitaAdopcion = voluntarioQueTramitaAdopcion;
    //     this.animalesAdoptados = animalesAdoptados;
    //     this.adoptante = adoptante;
    // }
    public Adopcion (Date fecha, Voluntario voluntarioQueTramitaAdopcion, Animal animalAdoptado, Adoptante adoptante){
        assert(fecha != null);
        assert(voluntarioQueTramitaAdopcion != null);

        assert (animalAdoptado!= null); 
        assert (adoptante!= null);

        this.fecha= fecha;
        this.adoptante= adoptante;
        this.animalAdoptado= animalAdoptado;
        this.voluntarioQueTramitaAdopcion= voluntarioQueTramitaAdopcion;

        this.animalAdoptado.addAdopcion(this);
        this.adoptante.addAdopcion(this);
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
    
    public Animal getAnimalAdoptado() {
        return animalAdoptado;
    }

    public void setAnimalAdoptado(Animal animal){
        this.animalAdoptado.removeAdopcion();
        this.animalAdoptado= animal;
        this.animalAdoptado.addAdopcion(this);
    }
    

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante.removeAdopcion(this);
        this.adoptante = adoptante;
        //Tenemos q transmitar la adopción por parte del voluntario
        this.adoptante.adoptar(this.animalAdoptado,this.voluntarioQueTramitaAdopcion);
    }
}
