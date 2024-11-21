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

    public Refugio(float liquidez, String nombre) {
        assert(liquidez>=0):"El valor liquidez debe de ser positivo o cero";

        this.liquidez = liquidez;
        this.animalesRefugiados = new LinkedList<>();
        this.animalesRegistrados = new LinkedList<>();
        this.socios= new LinkedList<>();

        this.nombre= nombre;
    }
    // ANIMALES REFUGIADOS
    // ----------------------------------------------------------
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
    protected void rmAllAnimalesRefugiados() {
        animalesRefugiados.clear();
    }

    //El metodo estaAnimal indica si el animal se encuentra en el refugio actualmente
    protected boolean containsAnimal(Animal animal){
        return this.animalesRefugiados.contains(animal);
    }
    // ----------------------------------------------------------
    // ANIMALES REGISTRADOS
    // ----------------------------------------------------------
    public Enumeration<Animal> getAnimalesRegistrados() {

        return Collections.enumeration(animalesRegistrados);
    } 

    protected boolean containsAnimalRegistro(Animal animal){
        return this.animalesRegistrados.contains(animal);
    }
    // ----------------------------------------------------------
    //SOCIOS DEL REFUGIO
    // ----------------------------------------------------------
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

    protected void registrar(Animal a) {
        //No compruebo que animal no sea null
        //porque ya se comprueba en el metodo registrar de Voluntario
        
        animalesRegistrados.add(a);
        animalesRefugiados.add(a);
        
    }

    protected void setLiquidez(float liquidez) {
        this.liquidez = liquidez;
    }

    public float getLiquidez() {
        return liquidez;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": "+this.nombre;
    }
}