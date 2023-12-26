
package Database_Project;

public class Database<E>{
    MyLinkedList<MyLinkedList<E>> IndexList;
    MyLinkedList<UserActivity> listUserActivity;
    
    public Database(){
         IndexList = new MyLinkedList<>("MyLinkedList");
         IndexList.ListName = "IndexList";
         listUserActivity = new MyLinkedList<>("UserActivity");
         listUserActivity.ListName = "List of UserActivity";
    }
    
  
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
    
    public void insertMany(MyLinkedList<E> Index, E[]element){
        if(elementExist(Index)!=null){
            IndexList.getNode(elementExist(Index)).element.addMany(element);
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),null,"Success"));
        }
        else{
            IndexList.add(Index);
            listUserActivity.add(new UserActivity("Insert new index which is "+Index.toString(),null,"Success"));
            
            IndexList.getNode(Index).element.addMany(element);
            listUserActivity.add(new UserActivity("Insert element to "+Index.toString(),null,"Success"));
        }  
    }
    
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

    public void get(MyLinkedList<E> Index, E element){
        if(IndexList.elementExist(Index)){
            //display the whole element in the specific index
            System.out.print("Index: "+Index.toString()+" > Value: ");
            IndexList.getNode(Index).element.displayInLinkedList();
            listUserActivity.add(new UserActivity("Get Index "+IndexList.toString(),null,"Success"));
            if(element!=null){
                if(IndexList.getNode(Index).element.elementExist(element)){
                    System.out.println("Index: "+Index.toString()+" > Value: "+IndexList.getNode(Index).element.getNode(element).element);
                    listUserActivity.add(new UserActivity("Get data from "+IndexList.toString(),element.toString(),"Success"));
                }
                else{
                    System.out.println("Element not found");
                    listUserActivity.add(new UserActivity("Get data from "+IndexList.toString(),element.toString(),"Fail. Element doesn't exist."));
                }  
            }
        }
        else{
            System.out.println("Index not found");
            listUserActivity.add(new UserActivity("Get Index "+IndexList.toString(),null,"Fail. Index doesn't exist"));
        }
    }
    
    public void display(){
            System.out.println("Display all data");
            //System.out.println("+---------------+--------------+---------------+");
            System.out.printf("%-13s %-13s %-13s%n","INDEX","TYPE","VALUE");
            //System.out.println("+---------------+--------------+---------------+");
        
        for (int i = 0; i < IndexList.size; i++) {
            System.out.printf("%-13s %-13s %1s",IndexList.getElement(i).ListName,
                    IndexList.getElement(i).dataType,"");
            IndexList.getElement(i).displayInLinkedList();
            System.out.println();
        }
    }
    
    public void viewHistory(){
        for (int i = 0; i < listUserActivity.size; i++) {
            listUserActivity.getElement(i).display();
        }
    }
    
    public MyLinkedList<E> ReturnIndexElement(String indexName){
        for (int i = 0; i < IndexList.size; i++) {
            if(IndexList.getElement(i).ListName.equalsIgnoreCase(indexName))
                return IndexList.getElement(i);
        }
        return null;
    }
    
    public MyLinkedList<E> elementExist(MyLinkedList<E> list){
        for (int i = 0; i < IndexList.size; i++) {
            if(IndexList.getElement(i).ListName.equalsIgnoreCase(list.ListName) 
                    && IndexList.getElement(i).dataType.equalsIgnoreCase(list.dataType)){
                return IndexList.getElement(i);
            }
        }
        return null;
    }
    
    public void clear(){
        IndexList.clear();
    }   
}

