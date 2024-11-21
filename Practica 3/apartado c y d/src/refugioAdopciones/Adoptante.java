package refugioAdopciones;
import java.util.*;
//Si el animal esta en tratamiento no puede ser adoptado

public class Adoptante extends Rol {
    private List<Adopcion> adopciones = new LinkedList<>();

    public Adoptante(tipoSocio rol) {
        super(rol);
        // como la relacion es de 0 a muchos entre animal y adoptante,
        // para que exista un adoptante no es necesario que haya adoptado un animal
    }

    public void adoptar(Animal disponibleParaAdopcion, Socio encargadoAdopcion, Refugio refugio, Socio socio) { 
        assert(disponibleParaAdopcion != null): "El animal es null";
        assert(encargadoAdopcion != null):"El voluntario encargado es null";

        assert(refugio == encargadoAdopcion.getRefugio());

        // La comprobacion de si el animal es del refugio del adoptante
        // y el voluntario esta en el mismo refugio que el animal se hace en el tramitarAdopcion

        Voluntario voluntario = (Voluntario) encargadoAdopcion.getRol(tipoSocio.voluntario);

        voluntario.tramitarAdopcion(disponibleParaAdopcion, socio, refugio, encargadoAdopcion);

    }

    public Enumeration<Adopcion> getAdopciones() {
        return Collections.enumeration(this.adopciones);
    }

    public void rmAdopcion(Adopcion adopcion) {
        this.adopciones.remove(adopcion);
    }

    public void addAdopcion(Adopcion adopcion) {
        this.adopciones.add(adopcion);
    }
}