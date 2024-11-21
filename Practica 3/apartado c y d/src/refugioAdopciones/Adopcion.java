 package refugioAdopciones;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adopcion {
    private Date fecha;

    private Socio encargadoAdopcion; 
    // private List<Animal> animalesAdoptados;
    private Socio adoptante;
    private Animal animalAdoptado;

    public Adopcion(Date fecha, Socio encargadoAdopcion, Animal animalAdoptado, Socio adoptante) {
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

        Adoptante rolAdoptante = (Adoptante) adoptante.getRol(tipoSocio.adoptante);
        rolAdoptante.addAdopcion(this);
    }

    public Date getFecha() {
        return fecha;
    }

    public Socio getEncargadoAdopcion() {
        return encargadoAdopcion;
    }

    public Animal getAnimalAdoptado() {
        return animalAdoptado;
    }

    public Socio getAdoptante() {
        return adoptante;
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
