package refugioAdopciones;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        // El no tiene sentido hacer que el refugio pida una lista de animales como parametro
        // ya que al crear un animal para meterlo en la lista, el animal necesita a su vez un refugio

        Refugio refugioDeLeo = new Refugio(0);

        Voluntario pepe = new Voluntario(refugioDeLeo, new Date());

        Animal perro = new Animal(new Date("2021/01/01"));
        Animal gato = new Animal(new Date("2022/03/01"));

        refugioDeLeo.addAnimalRefugiado(perro);
        refugioDeLeo.addAnimalRefugiado(gato);

        Adoptante paco = new Adoptante(refugioDeLeo, new Date(), pepe);

        pepe.tramitarAdopcion(perro, paco);
    }
}
