import java.util.*;

public class Rental {
    private Date startDate;
    private Date endDate;
    private RentalOffice pickUpOffice;

    public Rental(Date startDate, Date endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date setStartDate(){
        return startDate;
    }

    public void getStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date setEndDate(){
        return endDate;
    }

    public void getEndDate(Date endDate){
        this.endDate = endDate;
    }
    
}
