package refugioAdopciones;

import java.util.Date;

 public class Socio{
   private Date registro;
   private Refugio refugio;

   private String nombre;

   public Socio (Refugio refugio, Date registro,String nombre){
      assert(refugio!= null);
      assert(registro!= null);

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
       return this.getClass().getSimpleName() + "=> "+this.nombre+" ("+this.refugio+")";
   }
}