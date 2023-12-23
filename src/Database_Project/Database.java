package Database_Project;
import java.util.LinkedList;

public class Database<E>{
private Node head;

  public Database() {
        this.head = null;
    }
  
  
      
    public void insert(String index,String datatype,E data){
     Node newNode = new Node(index,datatype,data);
     newNode.nextNode =head;
     head= newNode;
    }
    
    
    public E get(String data){
        Node current = head;
        while(current!= null){
            if(current.index.equals(data)){
                return (E) current.value;
            }
            current = current.nextNode;
        }
        return null;
    }
        
        
    
    public void delete(E data){
    Node current=head;
    Node prev = null;
    
    while(current!=null && !current.index.equals(data)){
        prev = current;
        current = current.nextNode;
    }
    if(current!=null){
        
    }    
    
    
    }
    
    public void clear(){
       head=null;
    }

    //void insert(double data, String datatypeFromUser, String index) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
    public void display(){
        Node current = head;
        System.out.println("Display all data");
        System.out.println("+---------------+--------------+---------------+");
        System.out.println("|     INDEX     |     TYPE     |     VALUE     |");
        System.out.println("+---------------+--------------+---------------+");
         
        while(current!=null){
        System.out.printf(  "|%15s|%15s|%15s", current.index , current.type,current.value );
            System.out.println();
        current=current.nextNode;
        }
        System.out.println("+---------------+--------------+---------------+");
        
          
        
    }
    

    
    
    
    
    
        
    }
    
    
    
    

