package Database_Project;
import java.util.LinkedList;

public class Database<E>{
  MyLinkedList<E> ListData = new MyLinkedList<>();
  MyLinkedList<String> ListDataType = new MyLinkedList<>();
  MyLinkedList<String> ListIndex = new MyLinkedList<>();
  MyLinkedList<UserActivity> ListUA = new MyLinkedList<>();
  
      
    public void insert(E data,String datatype,String index){
      ListData.add(data);
      ListDataType.add(datatype);
      ListIndex.add(index);
  //    ListUA.add(new UserActivity("insert",data,"User insert a data",dateCreated));
       
       
    }
    public E get(E data){
        E dataUserWant;
       dataUserWant= (E) ListData.retrive(data);
        return dataUserWant;
     //   ListUA.add(new UserActivity("get",data,data,));
    }
    
    public void delete(E data){
        ListData.delete(data);
        
    }
    
    public void clear(){
        ListData.clear();
        ListDataType.clear();
    }

    //void insert(double data, String datatypeFromUser, String index) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
    public void display(){
        
           ListData.display();
        
    }
    
    
    
    
    
    
        
    }
    
    
    
    

