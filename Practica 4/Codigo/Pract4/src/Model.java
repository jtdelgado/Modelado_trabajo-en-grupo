public class Model {
    private String name;
    private Integer pricePerDay;

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

}
