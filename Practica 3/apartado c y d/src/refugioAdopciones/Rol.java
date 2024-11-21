package refugioAdopciones;

public class Rol {
    private tipoSocio rol;

    public Rol (tipoSocio rol){
        this.rol= rol;
    }

    public void setRol(tipoSocio rol){
        this.rol= rol;
    }
  
    public tipoSocio getRol(){
        return this.rol;
    } 
}
