package Database_Project;
//<<<<<<< Nadhea
import java.util.Date;

public class UserActivity<E>{
    private String typeCommand;
    private E dataInserted;
    private String dataDisplayed;
    private String dataRetrieved;
    private String dataDeleted;
    private String dataCleared;
    private String message;
    private Date dateActivity;
    
    public UserActivity(String typeCommand, E dataInserted, String message, Date dateActivity){
        this.typeCommand = typeCommand;
        this.dataInserted = dataInserted;
        this.message = message;
        
        this.dateActivity = dateActivity;
        
    }
    public Date getDateCreated(){
        return dateActivity;
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
=======
import java.util.LinkedList;

public class UserActivity{
    
}
//>>>>>>> main
