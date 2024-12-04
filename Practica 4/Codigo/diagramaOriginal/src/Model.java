import java.util.*;

public class Model {
    private String name;
    private Integer pricePerDay;
    
    private List<Car> cars; //asociacion BelongsTo

    public Model (String name,Integer pricePerDay ){
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getPricePerDay(){
        return this.pricePerDay;
    }

    public void setPricePerDay(Integer price){
        this.pricePerDay =price;
    }

    public Enumeration<Car> getCars(){
        return Collections.enumeration(cars);
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

}
