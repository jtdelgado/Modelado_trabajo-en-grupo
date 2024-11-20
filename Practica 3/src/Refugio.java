import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Refugio {
    private float liquidez;
    private List<Animal> animalesRefugiados;
    private List<Animal> animalesRegistrados;
    private List<Socio> socios;

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
        this.socios= new LinkedList<>();
    }

    // Métodos para operar con la relación de AnimalesRefugiados
    // diapositiva 23

    public Enumeration<Animal> getAnimalesRefugiados() {

        return Collections.enumeration(animalesRefugiados);
    }

    public void addAnimalRefugiado(Animal animal) {
        animalesRefugiados.add(animal);
    }

    public void rmAnimalRefugiado(Animal animal) {
        animalesRefugiados.remove(animal);
    }

    public void rmAllAnimalesRegistrado() {
        animalesRefugiados.clear();
    }

    // ANIMALES REGISTRADOS
    public Enumeration<Animal> getAnimalesRegistrados() {

        return Collections.enumeration(animalesRegistrados);
    } 

    public Enumeration<Socio> getSocios() {

        return Collections.enumeration(socios);
    }

    public void addSocios(Socio socio) {
        socios.add(socio);
    }

    public void rmSocio(Socio socio) {
        socios.remove(socio);
    }

    //SOCIOS DEL REFUGIO



    // ----------------------------------------------------------

    public void registrar(Animal a) {
        //No compruebo que animal no sea null
        //porque ya se comprueba en el metodo registrar de Voluntario
        
        animalesRegistrados.add(a);
        animalesRefugiados.add(a);
        
    }

    public void setLiquidez(float liquidez) {
        this.liquidez = liquidez;
    }

    public float getLiquidez() {
        return liquidez;
    }
}