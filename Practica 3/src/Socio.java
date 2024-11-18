 import java.util.Date;

 public class Socio{
   private Date registro;
   private Refugio refugio;

   public Socio (Refugio refugio, Date registro){
      assert(refugio!= null);
      assert(registro!= null);

      this.registro= registro;
      this.refugio= refugio;
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
}