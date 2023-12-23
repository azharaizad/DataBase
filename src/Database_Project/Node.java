/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database_Project;

/**
 *
 * @author User
 * @param <E>
 */
public class Node<E> {
    String index;
    E  value;
    E type;
    Node nextNode;
    
    public Node(String indexFromUser, E typeFromUser, E valueFromUser ){
    this.index = indexFromUser;
    value = valueFromUser;
    type = typeFromUser;
    }
    
    public void setNextNode(E value){
        nextNode.value = value;
    }
    
    public Node getNextNode(){
        return nextNode;
    }

    public E getValue() {
        return value;
    }

    public void setData(E value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return "Data: "+this.value;
    }
        
    
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database_Project;

/**
 *
 * @author User
 * @param <E>
 */
public class Node<E> {
    String index;
    E  value;
    E type;
    Node nextNode;
    
    public Node(String indexFromUser, E typeFromUser, E valueFromUser ){
    this.index = indexFromUser;
    value = valueFromUser;
    type = typeFromUser;
    }
    
    public void setNextNode(E value){
        nextNode.value = value;
    }
    
    public Node getNextNode(){
        return nextNode;
    }

    public E getValue() {
        return value;
    }

    public void setData(E value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return "Data: "+this.value;
    }
        
    
    
    
}
