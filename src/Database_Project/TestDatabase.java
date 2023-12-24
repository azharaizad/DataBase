package Database_Project;


import java.util.Date;
import java.util.Scanner;


public class TestDatabase{
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String command;
       String datatype;
       String datatypeFromUser;
       boolean o = true;
      Database<Object> stringDB = new Database<>();
      Database<UserActivity> userActivity = new Database<>();
      
      
            
   

       
       while(o){
           System.out.println("\n");
        System.out.println("My Simple Database Engine");
        System.out.println("Please Enter Command");
        System.out.println("- insert: Insert new data");
        System.out.println("- display: Display all data");
        System.out.println("- get: Get a specific data");
        System.out.println("- delete: Delete a specific data");
        System.out.println("- clear: Clear all data stored");
        System.out.println("- UA: Show user history");
        System.out.println("Command: ");
        command = input.nextLine();
        
        if(command.equals("insert")){
                
                System.out.println("Please enter a datatype('str' for string, 'c' for character, 'num' for numerical, 'X' for exit): ");
                datatype=input.nextLine();
                while(datatype.equals("str")|| datatype.equals("c")||datatype.equals("num")){
                if(datatype.equals("str")){
                    datatypeFromUser="string";
                    System.out.println("Please enter the data: ");
                    String data = input.nextLine();
                    System.out.println("Please enter the index: ");
                    String index = input.nextLine();
                  //  Database<String> stringDB = new Database<>();
                    stringDB.insert(index, datatypeFromUser,data);
         //           userActivity.insert(new UserActivity("insert",data,"user succesfully insert data",getDateCreated()));
                  
                    System.out.println("[Database] Inserting...");
                    System.out.println("[Database] Done!");
                }
                else if(datatype.equals("num")){
                    datatypeFromUser="number";
                    System.out.println("Please enter the data: ");
                    double data = input.nextDouble();
                    input.nextLine();
                    System.out.println("Please enter the index: ");
                    String index = input.nextLine();
                 //   Database<Double> stringDB = new Database<>();
                    stringDB.insert(index, datatypeFromUser,data);
           //         userActivity.insert(new UserActivity("insert",data,"user succesfully insert data",getDateCreated()));
                    System.out.println("[Database] Inserting...");
                    System.out.println("[Database] Done!");
                }
                else if(datatype.equals("c")){
                    datatypeFromUser="character";
                    System.out.println("Please enter the data: ");
                    char data = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("Please enter the index: ");
                    String index = input.nextLine();
               //     Database<Character> stringDB = new Database<>();
                    stringDB.insert(index, datatypeFromUser,data);
         //           userActivity.insert(new UserActivity("insert",data,"user succesfully insert data",getDateCreated()));
                  
                    
                    System.out.println("[Database] Inserting...");
                    System.out.println("[Database] Done!");
                }
                System.out.println("Please enter a datatype('str' for string, 'c' for character, 'num' for numerical, 'X' for exit): ");
                datatype=input.nextLine();
                }
                
                
        }
        else if(command.equals("get")){
           // Database StringDB = new Database();
             System.out.print("\nPlease enter the index to retrieve data: ");
             String retrieveIndex = input.nextLine();
                  
           Object result = stringDB.get(retrieveIndex);
       //     userActivity.insert(new UserActivity("get",result,"user succesfully get data",getDateCreated()));
                  
              if (result != null) {
                System.out.println("Data for index '" + retrieveIndex + "' : " + result);
            } else {
                System.out.println("No data found for index '" + retrieveIndex + "'");
      
        }     
              
        }else if(command.equals("clear")){
            stringDB.clear();
            System.out.println("\nClear all the data stored");
         //    userActivity.insert(new UserActivity("clear",null,"user succesfully clear data",getDateCreated()));
                  
        
       }else if(command.equals("delete")){
            System.out.print("\nPlease enter the index to delete data : ");
            String deleteIndex = input.nextLine();
            Object result = stringDB.get(deleteIndex);
          //  userActivity.insert(new UserActivity("insert",result,"user succesfully delete data",getDateCreated()));
                  
            stringDB.delete(deleteIndex);
            System.out.println("\nData Stored after delete:");
            stringDB.display();
       
        
        
       }else if(command.equals("display")){
            stringDB.display();
            
        }else if(command.equals("UA")){
            System.out.println("\nUser History:");
           userActivity.userActivityDisplay();
           // stringDB.displayUserHistory();
        }       
              
        
                
                
                
                
          
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
                
        }
    }
    public static Date getDateCreated(){
        Date date = new Date();
        return date;
    }
}
    
