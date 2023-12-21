package Database_Project;

import java.util.Scanner;

public class MyLinkedList{
    
    private Node head;
    
    // Node class
    private static class Node {
        Object data;
        Node next;
        
        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }
    
    // Method to add data to the linked list
    public void add(Object data){
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
    
    // Method to display all data in the linked list
    public void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    // Method to delete data at a specific index
    public void delete(int index){
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
    }
    
    // Method to clear all data in the linked list
    public void clear(){
        head = null;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList myLinkedList = new MyLinkedList();
        
        myLinkedList.add("Data 1");
        myLinkedList.add("Data 2");
        myLinkedList.add("Data 3");
        
        System.out.println("Display all data :");
        myLinkedList.display();
        
        System.out.println("Enter index to delete");
        int indexToDelete = scanner.nextInt();
        myLinkedList.delete(indexToDelete);
        
        System.out.println("Display all data after deletion :");
        myLinkedList.display();
        
        System.out.println("Clearing all data");
        myLinkedList.clear();
        myLinkedList.display();
    }
}