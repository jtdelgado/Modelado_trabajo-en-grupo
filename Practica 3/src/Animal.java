import java.util.Date;

public class Animal{
    private Date nacimiento;
    private EstadoAnimal estado;
    private Refugio refugio;

    private Adopcion adopcion;
    
    public Animal(Date nacimiento, EstadoAnimal estado, Refugio refugio){
        assert(refugio != null);
        assert(nacimiento != null);
        assert(estado != null);
        
        this.nacimiento = nacimiento;
        this.estado = estado;
        this.refugio = refugio;
    }

    public Date getNacimiento(){
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento){
        this.nacimiento = nacimiento;
    }

    public EstadoAnimal getEstado(){
        return estado;
    }

    public void setEstado(EstadoAnimal estado){
        this.estado = estado;
    }

    public Refugio getRefugio(){
        return refugio;
    }

    public void setRefugio(Refugio refugio){
        this.refugio = refugio;
    }


    //Clase asociacion: ADOPCION
    public void addAdopcion (Adopcion adopcion){
        this.adopcion= adopcion;
    }

    public void removeAdopcion (){
        this.adopcion= null;
    }

}