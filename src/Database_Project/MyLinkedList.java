
package Database_Project;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MyLinkedList<E> extends javax.swing.JFrame{
    
    Node<E> head,tail;
    int size;
    String ListName;
    String dataType;
    
    public MyLinkedList(String dataType) {
        head = null;
        size = 0;
        //this.ListName = ListName;
        this.dataType = dataType;
    }
     
    public MyLinkedList (E element, String dataType){
        add(element);
        //this.ListName = ListName;
        this.dataType = dataType;
    }
    
    public MyLinkedList (E[] element){
        addMany(element);
    }
    // Method to check empty
    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }
    
    // Method to clear
    public void clear(){
        head = null;
        tail = head;
        size = 0;
    }
    // Method to add data to the linked list
    public void add(E element){
        Node<E> newNode = new Node(element);
        
        if (head == null){
            head = newNode;
            tail = head;
        }
        else {
            Node<E> currentNode = head;
            
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addMany(E[] element){
        for (int i = 0; i < element.length; i++) {
            add(element[i]);
        }
    }
    
    public void addFirst(E element){
        Node<E> newNode = new Node(element);
        
        if(head==null){
            head = newNode;
            tail = head;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;    
    }
    
    public void addIndex(E element, int index){
        Node<E> newNode = new Node(element);
        
        if(head==null){
            head = newNode;
            tail = head;
        }
        else{
            int count = 0;
            Node<E> currentNode = head;
            while(count!=index-1){
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = newNode;
        }
        size++;
    }
    
    // Method to remove data to the linked list
    public E removeLast(){
        
        if(head==null){
            System.out.println("Nothing to remove");
            return head.element;
        }
        else if(size==1){
            Node<E> tempNode = head;
            head = null;
            tail = head;
            size--;
            return tempNode.element;
        }
        else{
            Node<E> currentNode =head;
            
            while(currentNode.next.next!=null){
                currentNode = currentNode.next;
            }
            
            Node<E> tempNode = currentNode.next;
            currentNode.next = null;
            tail = currentNode;
            size--;
            return tempNode.element;  
        }  
    }
    
    public E removeFirst(){
        if(head==null){
            System.out.println("Nothing to remove");
            return head.element;
        }
        else{
            Node<E> tempNode = head;
            head.next = head;
            size--;
            return tempNode.element;
        }
    }
    
    public E remove(E element) {
    if (head == null) {
        System.out.println("Nothing to remove");
        return null; // or throw an exception
    } 
    else if (head.element.equals(element)) {
        Node<E> tempNode = head;
        head = head.next;
        size--;

        if (head == null) {
            tail = null; // Set tail to null when size is 0
        }

        return tempNode.element;
    } 
    else {
        Node<E> currentNode = head;

        while (currentNode.next != null && !currentNode.next.element.equals(element)) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            System.out.println("Element not found");
            return null; // or throw an exception
        }

        Node<E> tempNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        size--;

        if (currentNode.next == null) {
            tail = currentNode; // Update tail if the last element is removed
        }

        return tempNode.element;
    }
}

    
    public E removeIndex(int index){
        if(head==null || index<0 || index>=size){
            System.out.println("Nothing to remove");
            return head.element;
        }
        else if(index == 0){
            return removeFirst();
        }
        else if(index == size-1){
            return removeLast();
        }
        else{
            int count = 0;
            Node<E> currentNode = head;
            
            while(count!=index-1){
                currentNode = currentNode.next;
                count++;
            }
            
            Node<E> tempNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            size--;
            return tempNode.element;
        }
    }
    
    // Method to retrieve data from the linked list
    public E getElement(int index){
        if(index < 0 || index >= size){
            System.out.println("Index out of bound");
            return null;
        }
        else{
            int count = 0;
            Node<E> currentNode = head;
       
            while(count!=index){
                currentNode = currentNode.next;
                count++;
            }
            
            return currentNode.element;
        } 
    }
    
    //method to retrieve index of linkedList from given data
    public int getindexOf(E element){
        Node<E> currentNode = head;
        int index=0;
        
        while(currentNode!=null){
            if(currentNode.element.equals(element)){
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        
        System.out.println("Element not found");
        return -1;
    }
    
    // Method to check element existence
    public boolean elementExist(E element){
        Node<E> currentNode = head;
        
        for (int i = 0; i < size; i++) {
            if(currentNode.element.equals(element))
                return true;
            
            currentNode = currentNode.next;
        }
        return false;
    }
    
    // Method to get certain node
    public Node<E> getNode(E element){
        Node<E> currentNode = head;
        
        for (int i = 0; i < size; i++) {
            if(currentNode.element.equals(element))
                return currentNode;
            
            currentNode = currentNode.next;
        }
        return null;
    }
    
    public String displayInLinkedList() {
        Node<E> currentNode = head;
        
        // Create a JTextArea to display the linked list elements
        JTextArea textArea = new JTextArea();
        for (int i = 0; i < size; i++) {
            
            textArea.append((String)currentNode.element);
            // Check if it's the last element
            if (currentNode.next != null) {
                textArea.append(", ");
            }

            currentNode = currentNode.next;
        }
        return textArea.getText();
    }
    
    @Override
    public String toString() {
        return ListName;
    }
}
