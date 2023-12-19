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
