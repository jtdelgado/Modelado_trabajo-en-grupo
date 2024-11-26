package refugioAdopciones;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Refugio {
    private float liquidez;
    private List<Animal> animalesRefugiados;
    private List<Animal> animalesRegistrados;
    private List<Socio> socios;


    private String nombre;
    // ESTE CONSTRUCTOR NO SE PUEDE USAR, PERO EN EL DIAGRAMA DE LOS APUNTES SE
    // DEFINE ASI
    // public Refugio(float liquidez, List<Animal> animalesRefugiados) {
    // this.liquidez = liquidez;
    // this.animalesRefugiados = animalesRefugiados;
    // }

    public Refugio(float liquidez, String nombre) {
        
        this.liquidez = liquidez;
        this.animalesRefugiados = new LinkedList<>();
        this.animalesRegistrados = new LinkedList<>();
        this.socios= new LinkedList<>();

        this.nombre= nombre;
    }

    // Métodos para operar con la relación de AnimalesRefugiados
    // diapositiva 23

    public Enumeration<Animal> getAnimalesRefugiados() {

        return Collections.enumeration(animalesRefugiados);
    }

    // El metodo addAnimalRefugiado es protected porque un donante no puede acceder a el
    protected void addAnimalRefugiado(Animal animal) {
        animalesRefugiados.add(animal);
    }

    // El metodo rmAnimalRefugiado es protected porque un donante no puede acceder a el
    protected void rmAnimalRefugiado(Animal animal) {
        animalesRefugiados.remove(animal);
    }

    // El metodo rmAllAnimalesRefugiados es protected porque un donante no puede acceder a el
    protected void rmAllAnimalesRegistrado() {
        animalesRefugiados.clear();
    }

    // ANIMALES REGISTRADOS
    public Enumeration<Animal> getAnimalesRegistrados() {

        return Collections.enumeration(animalesRegistrados);
    } 
    //SOCIOS DEL REFUGIO

    public Enumeration<Socio> getSocios() {

        return Collections.enumeration(socios);
    }

    // El metodo addSocios es protected porque un donante no puede acceder a el
    protected void addSocios(Socio socio) {
        socios.add(socio);
    }

    // El metodo rmSocio es protected porque un donante no puede acceder a el
    protected void rmSocio(Socio socio) {
        socios.remove(socio);
    }




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

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": "+this.nombre;
    }

    
}