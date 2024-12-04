import java.time.LocalDate;
import java.util.*;

public class RentalOnSite extends Rental {
    private String comments;

    public RentalOnSite(LocalDate startDate, LocalDate endDate, Customer customer, Car car,
            RentalOffice pickUpOffice, String comments, PromotionStrategy promotion) {

        super(startDate, endDate, customer, car, pickUpOffice, promotion);
        this.comments = comments;
    }

    public void getComments() {
        System.out.println(comments);
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
