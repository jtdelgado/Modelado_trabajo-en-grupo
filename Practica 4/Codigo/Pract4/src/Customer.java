public class Customer {
    private String name;
    private String dni;

    public Customer(String nombre, String id){
        this.name = nombre;
        this.dni = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getDNI(){
        return dni;
    }

    public void setDNI(String d){
        this.dni = d;
    }
}
