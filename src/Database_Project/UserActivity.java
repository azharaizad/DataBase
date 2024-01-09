
package Database_Project;

import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class UserActivity extends JFrame{
    private String typeActivity;
    private String data;
    private String status;
    private Date dateActivity;
    JTextArea textArea;
    JTextPane txtPane;
    
    public UserActivity(String typeActivity, String data, String status){
        this.typeActivity = typeActivity;
        this.data = data;
        this.status = status;
        dateActivity = new Date();
    }
    
    public String display(){
        textArea = new JTextArea();
        
        System.out.println("User Activity: ");
        System.out.println("Type of Command: " + typeActivity + " ("+dateActivity+")");
        System.out.println("Data Inserted: " + data );
        System.out.println("Status: "+status);
        System.out.println();
        
        textArea.append("User Activity: ");
        textArea.append("\nType of Command: " + typeActivity + " ("+dateActivity+")");
        textArea.append("\nData Inserted: " + data );
        textArea.append("\nStatus: "+status+"\n\n");
       
        return textArea.getText();
    }
}
