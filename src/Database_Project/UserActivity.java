
package Database_Project;

import java.util.Date;

public class UserActivity{
    private String typeActivity;
    private String data;
    private String status;
    private Date dateActivity;
    
    public UserActivity(String typeActivity, String data, String status){
        this.typeActivity = typeActivity;
        this.data = data;
        this.status = status;
        dateActivity = new Date();
    }
    
    public void display(){
        System.out.println("User Activity: ");
        System.out.println("Type of Command: " + typeActivity + " ("+dateActivity+")");
        System.out.println("Data Inserted: " + data );
        System.out.println("Status: "+status);
        System.out.println();
    }
}
