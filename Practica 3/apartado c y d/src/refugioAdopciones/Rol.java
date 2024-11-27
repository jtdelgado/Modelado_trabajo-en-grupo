package refugioAdopciones;

public class Rol {
    private tipoSocio rol;

    private Socio socio;

    public Rol (tipoSocio rol, Socio socio){
        this.rol= rol;
        this.socio = socio;
    }

    public void setRol(tipoSocio rol){
        this.rol= rol;
    }
  
    public tipoSocio getRol(){
        return this.rol;
    } 

    public Socio getSocio() {
        return socio;
    }
}
