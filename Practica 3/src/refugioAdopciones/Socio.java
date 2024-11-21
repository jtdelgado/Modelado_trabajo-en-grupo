package refugioAdopciones;
import java.text.SimpleDateFormat;
import java.util.Date;

 public class Socio{
   private Date registro;
   private Refugio refugio;

   private String nombre;

   public Socio (Refugio refugio, Date registro,String nombre){
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

   @Override
   public String toString() {
       // TODO Auto-generated method stub
       SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");

        // Formatear la fecha
        String fechaFormateada = formateador.format(this.registro);

       return this.getClass().getSimpleName() + "=> "+this.nombre+" ("+this.refugio+", "+fechaFormateada.toString()+")";
   }
}