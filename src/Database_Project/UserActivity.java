package Database_Project;
import java.util.Date;

public class UserActivity{
    private String typeCommand;
    private String dataInserted;
    private String dataDisplayed;
    private String dataRetrieved;
    private String dataDeleted;
    private String dataCleared;
    private Date dateActivity;
    
    public UserActivity(String typeCommand, String dataInserted, String dataDisplayed, String dataRetrieved, String dataDeleted, String dataCleared, Date dateActivity){
        this.typeCommand = typeCommand;
        this.dataInserted = dataInserted;
        this.dataDisplayed = dataDisplayed;
        this.dataRetrieved = dataRetrieved;
        this.dataDeleted = dataDeleted;
        this.dataCleared = dataCleared;
        this.dateActivity = dateActivity;
        
    }
    
    public void display(){
        System.out.println("User Activity: ");
        System.out.println("Type of Command: " + typeCommand + " ("+dateActivity+")");
        System.out.println("Data Inserted: " + dataInserted );
        System.out.println("Data Retrieved: " + dataRetrieved );
        System.out.println("Data Displayed: " + dataDisplayed );
        System.out.println("Data Deleted: " + dataDeleted );
        System.out.println("Data Cleared: " + dataCleared );
        
    }
}