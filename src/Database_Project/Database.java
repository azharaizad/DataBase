package Database_Project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Database<E> extends JFrame{
    //declare variable
    MyLinkedList<MyLinkedList<E>> IndexList;
    MyLinkedList<UserActivity> listUserActivity;
    JTextArea textArea;
    JTextPane txtPane;
    JScrollPane scrollPane;
    
    //constructor
    public Database(){
         IndexList = new MyLinkedList<>("MyLinkedList");
         IndexList.ListName = "IndexList";
         listUserActivity = new MyLinkedList<>("UserActivity");
         listUserActivity.ListName = "List of UserActivity";
         
    }
    
    //method to insert data
    public void insert(MyLinkedList<E> Index, E element){
        
        if(elementExist(Index)!=null){
            IndexList.getNode(elementExist(Index)).element.add(element);
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),element.toString(),"Success"));
        }
        else{
            IndexList.add(Index);
            listUserActivity.add(new UserActivity("Insert new index which is "+Index.toString(),null,"Success"));
            
            IndexList.getNode(Index).element.add(element);
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),element.toString(),"Success"));
        }        
    }
    
    //method to insert many data
    public void insertMany(MyLinkedList<E> Index, E[]element){
        textArea = new JTextArea();
        
        if(elementExist(Index)!=null){
            IndexList.getNode(elementExist(Index)).element.addMany(element);
            for (int i = 0; i < element.length; i++) {
                textArea.append(element[i].toString());
                if(i<element.length-1){
                    textArea.append(", ");
                }
            }
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),textArea.getText(),"Success"));
        }
        else{
            IndexList.add(Index);
            for (int i = 0; i < element.length; i++) {
                textArea.append(element[i].toString());
                if(i<element.length-1){
                    textArea.append(", ");
                }
            }
            listUserActivity.add(new UserActivity("Insert new index which is "+Index.toString(),textArea.getText(),"Success"));
            
            IndexList.getNode(Index).element.addMany(element);
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),textArea.getText(),"Success"));
        }  
    }
    
    //method to delete data
    public void deleteData(MyLinkedList<E> Index, E element){
        
        if(elementExist(Index)!=null){
            if(IndexList.getNode(elementExist(Index)).element.elementExist(element)){
                IndexList.getNode(elementExist(Index)).element.remove(element);
                listUserActivity.add(new UserActivity("Delete data "+Index.toString(),element.toString(),"Success"));
            }
            else{
                System.out.println("Element doesn't exist");
                listUserActivity.add(new UserActivity("Delete index "+Index.toString(),element.toString(),"Fail. Element doesn't exist."));
            }   
        }
        else{
            System.out.println("Index doesn't exist");
            listUserActivity.add(new UserActivity("Delete index "+Index.toString(),null,"Fail. Index doesn't exist"));
        }
    }

    //method to delete the whole index
    public void deleteIndex(MyLinkedList<E> Index){
        if(elementExist(Index)!=null){
            IndexList.remove(elementExist(Index));
            listUserActivity.add(new UserActivity("Delete index "+Index.toString(),null,"Success"));
        }
        else{
            System.out.println("Index doesn't exist");
            listUserActivity.add(new UserActivity("Index not found",null,"Fail. Index doesn't exist"));
        }
    }

    //method to get the data
    public void get(MyLinkedList<E> Index, E element){
        
        getContentPane().removeAll();
        textArea = new JTextArea();
        if(IndexList.elementExist(Index)){
            System.out.print("Index: "+Index.toString()+" > Value: ");
            textArea.append("Index: "+Index.toString()+" > Value: ");
            
            for (int i = 0; i < Index.size; i++) {
                System.out.println(Index.displayInLinkedList());
                textArea.append(Index.displayInLinkedList());
            }
            
            listUserActivity.add(new UserActivity("Get Index "+IndexList.toString(),null,"Success"));
            
            if(element!=null){
                if(IndexList.getNode(Index).element.elementExist(element)){
                    textArea.append("\nIndex: "+Index.toString()+" > Value: "+IndexList.getNode(Index).element.getNode(element).element);
                    System.out.println("Index: "+Index.toString()+" > Value: "+IndexList.getNode(Index).element.getNode(element).element);
                    listUserActivity.add(new UserActivity("Get data from "+IndexList.toString(),element.toString(),"Success"));
                }
                else{
                    textArea.append("Element not found");
                    System.out.println("Element not found");
                    listUserActivity.add(new UserActivity("Get data from "+IndexList.toString(),element.toString(),"Fail. Element doesn't exist."));
                }  
            }
        }
        else{
            textArea.append("Index not found");
            System.out.println("Index not found");
            listUserActivity.add(new UserActivity("Get Index "+IndexList.toString(),null,"Fail. Index doesn't exist"));
        }
        //getContentPane().removeAll();
        txtPane = new JTextPane();
        txtPane.setEditable(false);
        txtPane.setText(textArea.getText());
        
        // Create a JFrame to display the JTable
        JFrame frame = new JFrame("Display all data");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(txtPane);
        frame.setSize(500, 100);
        frame.setVisible(true);
    }
    
    //method to display the data
    public void display() {
        System.out.println("Display all data");

        // Create a JTable for displaying data
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("INDEX");
        tableModel.addColumn("TYPE");
        tableModel.addColumn("VALUE");

        for (int i = 0; i < IndexList.size; i++) {
            tableModel.addRow(new Object[]{
                    IndexList.getElement(i).ListName,
                    IndexList.getElement(i).dataType,
                    IndexList.getElement(i).displayInLinkedList()
                    });
        }
        getContentPane().removeAll();
        JTable jTable = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        // Create a JFrame to display the JTable
        JFrame frame = new JFrame("Display all data");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(jScrollPane);
        frame.setSize(700, 300);
        frame.setVisible(true);
    }
    
    //method to view history
    public void viewHistory(){
        textArea = new JTextArea();
        
        for (int i = 0; i < listUserActivity.size; i++) {
            textArea.append(listUserActivity.getElement(i).display());
        }
        
        txtPane = new JTextPane();
        txtPane.setEditable(false);
        txtPane.setText(textArea.getText());
        
        scrollPane = new JScrollPane(txtPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Create a JFrame to display the JTable
        JFrame frame = new JFrame("Display all history");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
    
    //method to find the element (return linkedlist)
    public MyLinkedList<E> ReturnIndexElement(String indexName){
        for (int i = 0; i < IndexList.size; i++) {
            if(IndexList.getElement(i).ListName.equalsIgnoreCase(indexName))
                return IndexList.getElement(i);
        }
        
        return null;
    }
    
    //method to check element existence
    public MyLinkedList<E> elementExist(MyLinkedList<E> list){
        for (int i = 0; i < IndexList.size; i++) {
            if(IndexList.getElement(i).ListName.equalsIgnoreCase(list.ListName) 
                    && IndexList.getElement(i).dataType.equalsIgnoreCase(list.dataType)){
                return IndexList.getElement(i);
            }
        }
        return null;
    }
    
    //method to clear all
    public void clear(){
        IndexList.clear();
    }   
}
