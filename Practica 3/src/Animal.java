import java.util.Date;

public class Animal {
    private Date nacimiento;
    private EstadoAnimal estado;
    private Refugio refugio;

    private Adopcion adopcion;

    public Animal(Date nacimiento) {
        assert (nacimiento != null);
        this.nacimiento = nacimiento;
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
    public void addAdopcion(Adopcion adopcion) {
        this.adopcion = adopcion;
        this.refugio.rmAnimalRefugiado(this);
        this.refugio = null;
    }

    public void removeAdopcion() {
        Refugio sitioAcogida = adopcion.getAdoptante().getRefugio();
        sitioAcogida.addAnimalRefugiado(this);
        this.refugio = sitioAcogida;
        this.adopcion = null;
    }

}