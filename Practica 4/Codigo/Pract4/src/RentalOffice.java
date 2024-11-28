import java.util.*;

public class RentalOffice{
    private String address;
    private int feeForDelivery;

    public RentalOffice(String address, int feeForDelivery){
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }

    public int getfeeForDelivery(){
        return feeForDelivery;
    }
    public String getaddress(){
        return address;
    }

    public void setFeeForDelivery(int feeForDelivery){
        this.feeForDelivery = feeForDelivery;
    }

    public void setAddress(String address){
        this.address = address;
    }

}