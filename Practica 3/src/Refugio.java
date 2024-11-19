import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Refugio {
    private float liquidez;
    private List<Animal> animalesRefugiados;
    private List<Animal> animalesRegistrados;

    // ESTE CONSTRUCTOR NO SE PUEDE USAR, PERO EN EL DIAGRAMA DE LOS APUNTES SE
    // DEFINE ASI
    // public Refugio(float liquidez, List<Animal> animalesRefugiados) {
    // this.liquidez = liquidez;
    // this.animalesRefugiados = animalesRefugiados;
    // }

    public Refugio(float liquidez) {
        this.liquidez = liquidez;
        this.animalesRefugiados = new LinkedList<>();
        this.animalesRegistrados = new LinkedList<>();
    }

    // Métodos para operar con la relación de AnimalesRefugiados
    // diapositiva 23

    // PREGUNTAR: Hay que usar enumeration si o si? O se puede usar List?
    public Enumeration<Animal> getAnimalesRefugiados() {

        return Collections.enumeration(animalesRefugiados);
    }

    public void addAnimalRefugiado(Animal animal) {
        animalesRefugiados.add(animal);
    }

    public void removeAnimalRefugiado(Animal animal) {
        animalesRefugiados.remove(animal);
    }

    public void removeAllAnimalesRegistrado() {
        animalesRefugiados.clear();
    }

    // ----------------------------------------------------------

    public void registrar(Animal a) {
        // falta por completar
    }

    public void setLiquidez(float liquidez) {
        this.liquidez = liquidez;
    }

    public float getLiquidez() {
        return liquidez;
    }
}