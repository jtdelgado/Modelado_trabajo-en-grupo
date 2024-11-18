import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Refugio{
    private float liquidez;
    private List<Animal> animalesRefugiados= new LinkedList<>();

    public Refugio(float liquidez,List<Animal> animalesRefugiados){
        this.liquidez = liquidez;
        this.animalesRefugiados= animalesRefugiados;
    }

    //Métodos para operar con la relación de AnimalesRefugiados
    //diapositiva 23
    public Enumeration<Animal> getAnimalesRefugiados() {

        return Collections.enumeration(animalesRefugiados);
    }

    public void addAnimalRefugiado (Animal animal){
        animalesRefugiados.add(animal);
    }

    public void removeAnimalRefugiado (Animal animal){
        animalesRefugiados.remove(animal);
    }

    //----------------------------------------------------------

    public void registrar (Animal a){
       //falta por completar  
    }

    public void setLiquidez(float liquidez){
        this.liquidez = liquidez;
    }

    public float getLiquidez(){
        return liquidez;
    }
}