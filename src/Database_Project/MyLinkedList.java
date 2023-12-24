package Database_Project;

//<<<<<<< Nadhea
import java.util.Scanner;

public class MyLinkedList<E>{
    
     private Node head;
    
    // Node class
    private static class Node<E> {
        E data;
        Node next;
        
        Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    
     public MyLinkedList() {
        head = null;
      
    }
    
    // Method to add data to the linked list
    public void add(E data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Method to retrieve data from the linked list
    public Object get(int index){
        if(index < 0){
            throw new IllegalArgumentException("Index cannot be negative");
        }
        Node current = head;
        int currentIndex = 0;
        
        while(current != null){
            if(currentIndex == index){
                return current.data;
           }
            current = current.next;
            currentIndex++;
        }
        
        throw new IndexOutOfBoundsException("Index out of bounds");
    }
    
    //method to retrieve index of linkedList from given data
    public int indexOf(String data){
        Node current = head;
        int index=0;
        while(current!=null){
            if(current.data.equals(data)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    public int getDataFromIndex(String data){
        int index = indexOf(data);
        if(index != -1){
            System.out.println("Index of '" + data + "': " + index);
        }else{
            
            System.out.println("'" + data + "' not found in the linked list.");
        }
        return index;
    }
    
   
            
        
    
    
    // Method to display all data in the linked list
    public void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    // Method to delete data at a specific index
  /*  public void delete(int index){
        if(index < 0){
            throw new IllegalArgumentException("Index cannot be negative");
        }
        
        if(index == 0){
            head = head.next;
            return;
        }
        
        Node current = head;
        int currentIndex = 0;
        
        while(current != null){
            if(currentIndex == index - 1){
                if(current.next != null){
                    current.next = current.next.next;
                    return;
                }
            }
            
            current = current.next;
            currentIndex++;
        }
        
        throw new IndexOutOfBoundsException("Index out of bounds");
    }*/
    
    public void delete(E data){
        Node current =head;
        while(current!= null){
            if(current.next.data==data){
                current.next =current.next.next;
            }
            current = current.next;
        }
        
    }
    
    public E retrive(String data){
        
        Node current = head;
           while(current!=null){
               if(current.data.equals(data)){
                   return (E) current.data;
               }
               current=current.next;
           }
           return  null;
    }    
        
    
    
    
    
    
    // Method to clear all data in the linked list
    public void clear(){
        head = null;
    }
    
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        MyLinkedList myLinkedList = new MyLinkedList();
//        
//        myLinkedList.add("Data 1");
//        myLinkedList.add("Data 2");
//        myLinkedList.add("Data 3");
//        
//        System.out.println("Display all data :");
//        myLinkedList.display();
//        
//        System.out.println("Enter index to delete");
//        int indexToDelete = scanner.nextInt();
//        myLinkedList.delete(indexToDelete);
//        
//        System.out.println("Display all data after deletion :");
//        myLinkedList.display();
//        
//        System.out.println("Clearing all data");
//        myLinkedList.clear();
//        myLinkedList.display();
//    }
=======

    }
