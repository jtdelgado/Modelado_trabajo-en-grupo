package refugioAdopciones;

import java.util.*;
import refugioDonaciones.*;


public class App {
    public static void main(String[] args) throws Exception {
        //COMPROBACION DE LOS TOSTRING() HACIA ABAJO

        // Refugio refugio1 = new Refugio(10,"santa fe");

        // System.out.println(refugio1);
        // Voluntario voluntario= new Voluntario(refugio1, new Date(), "luis");

        // Adoptante adoptante1 = new Adoptante(refugio1, new Date(), voluntario, "paco");

        // Donante donante = new Donante(new Date(), refugio1, null, "lop");

        // System.out.println(voluntario.toString()+"\t"+ adoptante1.toString()+" \t"+ donante.toString()+"\n");

        // Animal perro1 = new Animal(new Date(), "unicornio");

        // perro1.setEstado(EstadoAnimal.disponible);
        // perro1.setRefugio(refugio1);

        // System.out.println(perro1+"\n");

        // Adopcion adopcion = new Adopcion(new Date(), voluntario, perro1, adoptante1);

        // System.out.println(adopcion);

        // Donacion donacion = new Donacion(1000, new Date());

        // System.out.println(donacion);


        Refugio refugio1 = new Refugio(10, "Refugio de la Santísima Trinidad");
        Refugio refugio2 = new Refugio(0, "Cielo Animal");

        System.out.println("La lista de animales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        Animal perro = new Animal(new Date(2022,2,11),"FIRULAIS(PERRO)");
        Animal gato = new Animal(new Date(2010,12,3),"BOLITA(GATO)");
        Animal conejo = new Animal(new Date(2023,5,11),"NIEVE(CONEJO)");
        Animal cerdo = new Animal(new Date(2015,10,3),"GORDI(CERDO)");

        Voluntario voluntario1= new Voluntario(refugio1, new Date(), "luis");
        Voluntario voluntario2= new Voluntario(refugio2, new Date(), "teresa");


        Adoptante adoptante1 = new Adoptante(refugio1, new Date(), "paco");
        Adoptante adoptante2 = new Adoptante(refugio2, new Date(), "lidia");


        Donante donante = new Donante(new Date(), refugio2, null, "lop");


        //Añadimos los animales a los refugios

        //REFUGIO 1        
        voluntario1.registrar(cerdo);
        voluntario1.registrar(gato);
        System.out.println("La lista de animales actuales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        //REFUGIO 2
        voluntario2.registrar(perro);
        voluntario2.registrar(conejo);
        System.out.println("La lista de animales actuales del "+refugio2);
        imprimirLista(refugio2.getAnimalesRefugiados());


        //ADOPCIÓN 
        System.out.println("El adoptante "+adoptante1.getNombre()+ " adopta a "+cerdo.getNombre());
        adoptante1.adoptar(cerdo, voluntario1);





        //ERROR: No comprueba que el voluntario sea del mismo refugio al igual que el animal

        System.out.println("La lista de animales actuales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        System.out.println("La lista de animales registrados del "+refugio1);
        imprimirLista(refugio1.getAnimalesRegistrados());

        System.out.println("La lista de animales actuales del "+refugio2);
        imprimirLista(refugio2.getAnimalesRefugiados());

        System.out.println("La lista de animales registrados del "+refugio2);
        imprimirLista(refugio2.getAnimalesRegistrados());

        
    }
        
        
    public static void imprimirLista (Enumeration<?> lista){
        System.out.println("-------------------- ");
        int i=0;
        while(lista.hasMoreElements()){
            System.out.println(i+"- "+lista.nextElement());
            i++;
        }
        if(i==0) System.out.println("No hay elementos ");
        System.out.println("-------------------- \n");

    }
}
