package refugioAdopciones;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // El no tiene sentido hacer que el refugio pida una lista de animales como parametro
        // ya que al crear un animal para meterlo en la lista, el animal necesita a su vez un refugio

        Refugio refugioDeLeo = new Refugio(0);

        Voluntario pepe = new Voluntario(refugioDeLeo, new Date());

        Animal perro = new Animal(new Date("2021/01/01"));
        Animal gato = new Animal(new Date("2022/03/01"));

        pepe.registrar(perro);
        pepe.registrar(gato);

        System.out.println("Animales registrados en el refugio:");

        List<Animal> animalesRegistrados = Collections.list(refugioDeLeo.getAnimalesRegistrados());

        System.out.println(animalesRegistrados);

        System.out.println("Animales refugiados en el refugio:");

        List<Animal> animalesRefugiados = Collections.list(refugioDeLeo.getAnimalesRefugiados());

        System.out.println(animalesRefugiados);

        

        Adoptante paco = new Adoptante(refugioDeLeo, new Date(), pepe);

        pepe.tramitarAdopcion(perro, paco);

        System.out.println("Animales refugiados en el refugio despues de la adopcion:");

        animalesRefugiados = Collections.list(refugioDeLeo.getAnimalesRefugiados());

        System.out.println(animalesRefugiados);
    }
}
