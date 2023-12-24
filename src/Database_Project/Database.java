//<<<<<<< Nadhea
package Database_Project;

import java.util.Date;


public class Database<E>{
private Node head;

//MyLinkedList<Object> UserActivity = new MyLinkedList<>();

  public Database() {
        this.head = null;
    }
  
    
      
    public void insert(String index,String datatype,E data){
     Node newNode = new Node(index,datatype,data);
     newNode.nextNode =head;
     head= newNode;
   //  UserActivity.add(new UserActivity("insert",data,"User succesfully inserted data",date));
    }
    
     public void insert(UserActivity data) {
        Node newNode = new Node(data);
        newNode.nextNode = head;
        head = newNode;
    }

    
    
    
    public E get(String data){
        Node current = head;
        while(current!= null){
            if(current.index.equals(data)){
           //    UserActivity.add(new UserActivity("get",current.value,"User succesfully get the data",date));
               return (E) current.value;
               
            }
            current = current.nextNode;
        }
        
        return null;
    }
    
    public void delete(String data){
    Node current = head;
    Node prev = null;

    while (current != null && (current.index == null || !current.index.equals(data))) {
        prev = current;
        current = current.nextNode;
    }

    if (current != null) {
        if (prev != null) {
            prev.nextNode = current.nextNode;
        } else {
            head = current.nextNode;
        }
    }
        
    }
        
        
    
       public void clear(){
       head=null;
     //  UserActivity.add(new UserActivity("clear",null,"User succesfully clear all the data",date));
  
    }

    
    
    public void display(){
        Node current = head;
        System.out.println("\nDisplay all data");
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
    public void userActivityDisplay(){
        Node current =head;
        while(current!=null){
            System.out.println(current.data);
            current=current.nextNode;
        }
    }
    
   
    
    
    
    
    
        
    }
    
    
    
    

=======
package Database_Project;
import java.util.LinkedList;

public class Database<E>{
   LinkedList userData = new LinkedList();
 
    
    Node<E> head;
    Node<E> tail;
    
    public void storeData(String index,Node<E> type , Node<E> value){
       Node<E> newNode = new Node(index,type,value);
       userData.add(newNode);
        System.out.println("aaa");
       
        
    }
    
    
    
    
}
//>>>>>>> main
