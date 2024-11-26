package refugioAdopciones;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 public class Socio{
   private Date registro;
   private Refugio refugio;

   private String nombre;

   private List<Rol> roles = new ArrayList<>(3);

   public Socio (Refugio refugio, Date registro,String nombre){
      //roles = new LinkedList<>();
      assert(refugio!= null):"El refugio es null";
      assert(registro!= null):"El registro es null";

      this.registro= registro;
      this.refugio= refugio;

      this.nombre= nombre;
   }

   public void setRefugio(Refugio refugio){
      this.refugio= refugio;
   }

   public Refugio getRefugio(){
      return this.refugio;
   } 

   public void setRegistro(Date registro){
      this.registro= registro;
   }

   public Date getRegistro(){
      return this.registro;
   }

   public String getNombre(){
      return nombre;
   }

   public void setNombre(String nombre){
      this.nombre= nombre;
   }

   public void addRol(Rol rol){
      tipoSocio tipo = rol.getRol();

      boolean tieneRol = false;

      for(Rol r : roles){ 
         if (r.getRol() == tipo){
            tieneRol = true;
         }
      }

      assert(!tieneRol):"El rol ya esta asignado a este socio" ;
      // comprueba que ese rol no esté ya asignado al socio

      roles.add(rol);
   }

   public void eliminarRol(Rol rol){
      tipoSocio tipo = rol.getRol();

      boolean tieneRol = false;

      for(Rol r : roles){ 
         if (r.getRol() == tipo){
            roles.remove(r);
            tieneRol = true;
         }
      }

      assert(tieneRol):"El rol no esta asignado a este socio" ;
      // comprueba que ese rol no esté asignado al socio
   }

   public Rol getRol(tipoSocio rol){
      boolean tieneRol = false;
      Rol res = null;

      for(Rol r : roles){ 
         if (r.getRol() == rol){
            res = r;
            tieneRol = true;
         }
      }

      assert(tieneRol):"El rol no esta asignado a este socio" ;
      // comprueba que ese rol no esté asignado al socio

      return res;
   }

   @Override
   public String toString() {
       SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        // Formatear la fecha
        String fechaFormateada = formateador.format(this.registro);

       return this.getClass().getSimpleName() + "=> "+this.nombre+" ("+this.refugio+", "+fechaFormateada.toString()+")";
   }
}