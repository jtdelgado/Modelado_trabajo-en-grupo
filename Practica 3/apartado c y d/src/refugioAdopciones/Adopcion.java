 package refugioAdopciones;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adopcion {
    private Date fecha;

    private Voluntario encargadoAdopcion;
    // private List<Animal> animalesAdoptados;
    private Adoptante adoptante;
    private Animal animalAdoptado;

    public Adopcion(Date fecha, Voluntario encargadoAdopcion, Animal animalAdoptado, Adoptante adoptante) {
        assert (fecha != null): "La fecha es null";
        assert (encargadoAdopcion != null): "El encargado de la adopcion es null";

        assert (animalAdoptado != null): "el animal adoptado es null";
        assert (adoptante != null): "el adoptante es null";

        this.fecha = fecha;
        this.adoptante = adoptante;
        this.animalAdoptado = animalAdoptado;
        this.encargadoAdopcion = encargadoAdopcion;

        //El animal se elimina de la lista de animalesRefugiados cuando se adopta
        // esto lo hace el metiodo addAdopcion
        this.animalAdoptado.addAdopcion(this);


        adoptante.addAdopcion(this);
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
    protected  void deleteAdopcion(){
        this.adoptante.rmAdopcion(this);
        this.animalAdoptado.rmAdopcion();
        this.encargadoAdopcion.rmTramite(this);

        this.fecha = null;
        this.adoptante = null;
        this.animalAdoptado = null;
        this.encargadoAdopcion = null;

        //No lo eliminamos de los trámites de el voluntario porque queremos mantener una memoria de las adopciones
    }

    // No pondremos setters de adopcion por facilidad de codigo
    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        // Formatear la fecha
        String fechaFormateada = formateador.format(this.fecha);

        
        return this.getClass().getSimpleName()+"=> \n\tFecha: "+fechaFormateada+", \n\tEncargado "+this.encargadoAdopcion
                +", \n\t"+this.adoptante+", \n\t"+this.animalAdoptado+"\n";
    }

    
}
