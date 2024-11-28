 import java.util.*;

public class RentalOnSite {
    private String comments;

   public RentalOnSite(String comments){
        this.comments = comments;
    }

    public void getComments(){
        System.out.println(comments);
    }

    public void setComments(String comments){
        this.comments = comments;
    }
}
