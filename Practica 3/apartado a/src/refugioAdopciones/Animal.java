package refugioAdopciones;
import java.util.Date;

public class Animal {
    private Date nacimiento;
    private EstadoAnimal estado;
    private Refugio refugio;
    private Adopcion adopcion;

    private String nombre;

    // El animal no tiene un refugio ni estado asignado al principio ya que eso
    // se encarga el voluntario cuando lo registra
    public Animal(Date nacimiento,String nombre) {
        assert (nacimiento != null):"La fecha es null";
        this.nacimiento = nacimiento;
        this.nombre= nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    // Clase asociacion: ADOPCION
    protected void addAdopcion(Adopcion adopcion) {
        //Añadimos la adopción al animal y lo eliminamos de la lista del refugio actual
        this.adopcion = adopcion;
        this.refugio.rmAnimalRefugiado(this);

        
    }

    protected void rmAdopcion() {
        //Cuando eliminamos la adopción devolvemos el animal a su antiguo refugio
        this.refugio.addAnimalRefugiado(this);
        this.adopcion = null;
        this.estado = EstadoAnimal.disponible;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"=> "+ this.nombre +", estado: "+this.estado+", "+this.refugio.toString();
    }


    

}