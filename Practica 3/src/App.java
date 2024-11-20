import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // El no tiene sentido hacer que el refugio pida una lista de animales como parametro
        // ya que al crear un animal para meterlo en la lista, el animal necesita a su vez un refugio

        Refugio refugioDeLeo = new Refugio(0);
        Animal perro = new Animal(null, null, null);
    }
}
