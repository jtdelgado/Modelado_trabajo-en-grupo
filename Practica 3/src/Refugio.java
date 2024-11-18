import java.util.List;

public class Refugio{
    private float liquidez;
    private List<Animal> animalesDisponiblesParaAdopcion;

    public List<Animal> getAnimalesDisponiblesParaAdopcion() {
        return animalesDisponiblesParaAdopcion;
    }

    public void registrar (Animal a){
        
    }

    public void setLiquidez(float liquidez){
        this.liquidez = liquidez;
    }

    public float getLiquidez(){
        return liquidez;
    }
}