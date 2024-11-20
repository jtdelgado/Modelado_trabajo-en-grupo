package refugioAdopciones;

import java.util.Date;
import refugioDonaciones.Donacion;
import refugioDonaciones.Donante;

public class App {
    public static void main(String[] args) throws Exception {
        // El no tiene sentido hacer que el refugio pida una lista de animales como parametro
        // ya que al crear un animal para meterlo en la lista, el animal necesita a su vez un refugio

        // Refugio refugioDeLeo = new Refugio(0);

        // Voluntario pepe = new Voluntario(refugioDeLeo, new Date());

        // Animal perro = new Animal(new Date("2021/01/01"));
        // Animal gato = new Animal(new Date("2022/03/01"));

        // pepe.registrar(perro);
        // pepe.registrar(gato);

        // System.out.println("Animales registrados en el refugio:");

        // List<Animal> animalesRegistrados = Collections.list(refugioDeLeo.getAnimalesRegistrados());

        // System.out.println(animalesRegistrados);

        // System.out.println("Animales refugiados en el refugio:");

        // List<Animal> animalesRefugiados = Collections.list(refugioDeLeo.getAnimalesRefugiados());

        // System.out.println(animalesRefugiados);

        

        // Adoptante paco = new Adoptante(refugioDeLeo, new Date(), pepe);

        // pepe.tramitarAdopcion(perro, paco);

        // System.out.println("Animales refugiados en el refugio despues de la adopcion:");

        // animalesRefugiados = Collections.list(refugioDeLeo.getAnimalesRefugiados());

        // System.out.println(animalesRefugiados);
        Refugio refugio1 = new Refugio(10,"santa fe");

        System.out.println(refugio1);
        Voluntario voluntario= new Voluntario(refugio1, new Date(), "luis");

        Adoptante adoptante1 = new Adoptante(refugio1, new Date(), voluntario, "paco");

        Donante donante = new Donante(new Date(), refugio1, null, "lop");

        System.out.println(voluntario.toString()+"\t"+ adoptante1.toString()+" \t"+ donante.toString()+"\n");

        Animal perro1 = new Animal(new Date(), "unicornio");

        perro1.setEstado(EstadoAnimal.disponible);
        perro1.setRefugio(refugio1);

        System.out.println(perro1+"\n");

        Adopcion adopcion = new Adopcion(new Date(), voluntario, perro1, adoptante1);

        System.out.println(adopcion);

        Donacion donacion = new Donacion(1000, new Date());

        System.out.println(donacion);

    }
}
