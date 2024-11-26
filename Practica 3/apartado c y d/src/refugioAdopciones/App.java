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

        System.out.println("\nLa lista de animales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        // Se crean los animales y socios
        Animal perro = new Animal(new Date(2022,2,11),"FIRULAIS(PERRO)");
        Animal gato = new Animal(new Date(2010,12,3),"BOLITA(GATO)");
        Animal conejo = new Animal(new Date(2023,5,11),"NIEVE(CONEJO)");
        Animal cerdo = new Animal(new Date(2015,10,3),"GORDI(CERDO)");
        Animal tortuga = new Animal(new Date(2015,10,3), "CAPI(TORTUGA)");
        Socio voluntario1= new Socio(refugio1, new Date(), "luis");
        voluntario1.addRol(new Voluntario());
        Socio voluntario2= new Socio(refugio2, new Date(), "teresa");
        voluntario2.addRol(new Voluntario());

        Socio adoptanteDonante1 = new Socio(refugio1, new Date(), "paco");
        adoptanteDonante1.addRol(new Adoptante());
        adoptanteDonante1.addRol(new Donante());

        Socio adoptante2 = new Socio(refugio2, new Date(), "lidia");
        adoptante2.addRol(new Adoptante());


        Socio adoptanteVoluntario = new Socio(refugio2, new Date(), "lop");
        adoptanteVoluntario.addRol(new Adoptante());
        adoptanteVoluntario.addRol(new Voluntario());

        //Añadimos los animales a los refugios

        System.out.println("\nEl voluntario: " + voluntario1.getNombre() + " registra a " + cerdo.getNombre()
        + "y a " + gato.getNombre() + " en el refugio " + refugio1);
        //REFUGIO 1        
        ((Voluntario) voluntario1.getRol(tipoSocio.voluntario)).registrar(cerdo, refugio1);
        ((Voluntario) voluntario1.getRol(tipoSocio.voluntario)).registrar(gato, refugio1);

        System.out.println("· La lista de animales actuales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        System.out.println("El voluntario: " + voluntario2.getNombre() + " registra a " + perro.getNombre()
        + "y a " + conejo.getNombre() + " en el refugio " + refugio2);
        //REFUGIO 2        
        ((Voluntario) voluntario2.getRol(tipoSocio.voluntario)).registrar(perro, refugio2);
        ((Voluntario) voluntario2.getRol(tipoSocio.voluntario)).registrar(conejo, refugio2);

        System.out.println("· La lista de animales actuales del "+refugio2);
        imprimirLista(refugio2.getAnimalesRefugiados());


        //ADOPCIÓN y DONACION por parte de un adoptante que es a su vez un donante
        System.out.println("El adoptante/donante: "+adoptanteDonante1.getNombre()+ " adopta a "+gato.getNombre());

        ((Adoptante) adoptanteDonante1.getRol(tipoSocio.adoptante))
                    .adoptar(gato, voluntario1, refugio1, adoptanteDonante1);

        System.out.println("· La lista de animales actuales del "+refugio1);
        imprimirLista(refugio1.getAnimalesRefugiados());

        System.out.println("El adoptante/donante: "+adoptanteDonante1.getNombre()+ " dona 1000 al refugio "+refugio2);
        ((Donante) adoptanteDonante1.getRol(tipoSocio.donante)).donar(1000, refugio2);

        System.out.println("El refugio2 tiene una liquidez de "+refugio2.getLiquidez()+" u.m.\n");

        //Registro de un animal y adopcion de un voluntario que es a su vez adoptante
        System.out.println("El adoptante/voluntario: "+adoptanteVoluntario.getNombre() + " registra a "+tortuga.getNombre());
        ((Voluntario) adoptanteVoluntario.getRol(tipoSocio.voluntario))
                    .registrar(tortuga, refugio2);
        System.out.println("· La lista de animales actuales del "+refugio2);
        imprimirLista(refugio2.getAnimalesRefugiados());
        

        System.out.println("El adoptante/voluntario: "+adoptanteVoluntario.getNombre() + " adopta a "+tortuga.getNombre()+" por "+adoptanteVoluntario.getNombre());
        ((Adoptante) adoptanteVoluntario.getRol(tipoSocio.adoptante))
                    .adoptar(tortuga, adoptanteVoluntario, refugio2, adoptanteVoluntario);

        System.out.println("· La lista de animales actuales del "+refugio2);
        imprimirLista(refugio2.getAnimalesRefugiados());

        //
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
        //System.out.println("-------------------- ");
        int i=0;
        while(lista.hasMoreElements()){
            System.out.println("\t" + i+"- "+lista.nextElement());
            i++;
        }

        if(i>0){
            System.out.println("\n");
        }
        if(i==0) System.out.println("No hay elementos ");
        //System.out.println("-------------------- \n");

    }
}
