
package Database_Project;

import java.util.Scanner;

public class TestDatabase{
    
    public static void main(String[] args) {
        Database db = new Database<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        
        while(flag){
            System.out.println("""
                               Choose your command:
                               1. INSERT
                               2. DELETE
                               3. GET
                               4. DISPLAY DATABASE
                               5. CLEAR
                               6. VIEW HISTORY
                               7. CLOSE DATABASE
                               """);
            int command = sc.nextInt();
            
            if(command==1){
                System.out.println("""
                                   Choose data type:
                                   1. STRING
                                   2. INTEGER
                                   3. DOUBLE
                                   4. CHARACTER
                                   5. DATA COLLECTION (ARRAY)
                                   """);
                int dataType = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter Index name:");
                String indexName = sc.nextLine();
                sc.nextLine();
                
                switch(dataType){
                    case 1:{
                        MyLinkedList<String> StringIndex = new MyLinkedList<>("String");
                        StringIndex.ListName = indexName;
                        System.out.print("Enter the value:");
                        String value = sc.nextLine();
                        sc.nextLine();
                        db.insert(StringIndex, value);
                        break;
                    }
                    case 2:{
                        MyLinkedList<Integer> IntegerIndex = new MyLinkedList<>("Integer");
                        IntegerIndex.ListName = indexName;
                        System.out.print("Enter the value:");
                        Integer value = sc.nextInt();
                        db.insert(IntegerIndex, value);
                        break;
                    }
                    case 3:{
                        MyLinkedList<Double> DoubleIndex = new MyLinkedList<>("Double");
                        DoubleIndex.ListName = indexName;
                        System.out.print("Enter the value:");
                        Double value = sc.nextDouble();
                        db.insert(DoubleIndex, value);
                        break;
                    }
                    case 4:{
                        MyLinkedList<Character> CharacterIndex = new MyLinkedList<>("Character");
                        CharacterIndex.ListName = indexName;
                        System.out.print("Enter the value:");
                        Character value = sc.next().charAt(0);
                        db.insert(CharacterIndex, value);
                        break;
                    }
                    case 5:{
                        System.out.println("""
                                           Choose collection data type:
                                           1. String
                                           2. Integer
                                           3. Double
                                           4. Character
                                           """);
                        int collectionDataType = sc.nextInt();
                        sc.nextLine();
                        switch(collectionDataType){
                            case 1:{
                                MyLinkedList<String> StringIndex = new MyLinkedList<>("String");
                                StringIndex.ListName = indexName;
                                System.out.print("Enter the value (Split by coma & No space):");
                                String value = sc.nextLine();
                                sc.nextLine();
                                String[] ArrayValue = value.split(",");
                                db.insertMany(StringIndex, ArrayValue);
                                break;
                            }
                            case 2:{
                                MyLinkedList<Integer> IntegerIndex = new MyLinkedList<>("Integer");
                                IntegerIndex.ListName = indexName;
                                System.out.print("Enter the value (Split by coma & No space):");
                                String value = sc.nextLine();
                                //sc.nextLine();
                                String[] strArrayValue = value.split(",");
                                Integer[] ArrayValue = new Integer[strArrayValue.length];
                                for (int i = 0; i < ArrayValue.length; i++) {
                                    ArrayValue[i] = Integer.parseInt(strArrayValue[i]);
                                } 
                                db.insertMany(IntegerIndex, ArrayValue);
                                break;
                            }
                            case 3:{
                                MyLinkedList<Double> DoubleIndex = new MyLinkedList<>("Double");
                                DoubleIndex.ListName = indexName;
                                System.out.print("Enter the value (Split by coma & No space):");
                                String value = sc.nextLine();
                                sc.nextLine();
                                String[] strArrayValue = value.split(",");
                                Double[] ArrayValue = new Double[strArrayValue.length];
                                for (int i = 0; i < ArrayValue.length; i++) {
                                    ArrayValue[i] = Double.parseDouble(strArrayValue[i]);
                                }
                                db.insertMany(DoubleIndex,ArrayValue);
                                break;
                            }
                            case 4:{
                                MyLinkedList<Character> CharacterIndex = new MyLinkedList<>("Character");
                                CharacterIndex.ListName = indexName;
                                System.out.print("Enter the value (Split by coma & No space):");
                                String value = sc.nextLine();
                                sc.nextLine();
                                String[] strArrayValue = value.split(",");
                                Character[] ArrayValue = new Character[strArrayValue.length];
                                for (int i = 0; i < ArrayValue.length; i++) {
                                    ArrayValue[i] = strArrayValue[i].charAt(0);
                                }
                                db.insertMany(CharacterIndex,ArrayValue);
                                break;
                            }
                        }
                    }
                }
            }
            else if(command==2){
                //DELETE
                System.out.println("""
                                   Which one you want to delete:
                                   1. Delete the whole Index
                                   2. Delete specific data
                                   """);
                int deletion = sc.nextInt();
                sc.nextLine();
                if(deletion==1){
                    db.display();
                    System.out.println("Enter index Name:");
                    String indexName = sc.nextLine();
                    sc.nextLine();
                    
                    db.deleteIndex(db.ReturnIndexElement(indexName));
                }
                else{
                    db.display();
                    System.out.println("Enter index Name:");
                    String indexName = sc.nextLine();
                    sc.nextLine();
                    
                    System.out.println("Enter data:");
                    
                    String dataType = db.ReturnIndexElement(indexName).dataType;
                    
                    if(dataType.equalsIgnoreCase("String")){
                        String data = sc.nextLine();
                        sc.nextLine();
                        db.deleteData(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Integer")){
                        Integer data = sc.nextInt();
                        db.deleteData(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Double")){
                        Double data = sc.nextDouble();
                        db.deleteData(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Character")){
                        Character data = sc.next().charAt(0);
                        db.deleteData(db.ReturnIndexElement(indexName), data);
                    }
                }
            }
            else if(command==3){
                //GET
                db.display();
                sc.nextLine();
                System.out.println("Enter index Name:");
                String indexName = sc.nextLine();
                sc.nextLine();
                
                db.get(db.ReturnIndexElement(indexName), null);
                
                System.out.println("""
                                   1. Get Specific data
                                   2. Cancel
                                   """);
                int get = sc.nextInt();
                sc.nextLine();
                if(get==1){
                    System.out.println("Enter data:");
                    String dataType = db.ReturnIndexElement(indexName).dataType;
                    
                    if(dataType.equalsIgnoreCase("String")){
                        String data = sc.nextLine();
                        sc.nextLine();
                        db.get(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Integer")){
                        Integer data = sc.nextInt();
                        db.get(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Double")){
                        Double data = sc.nextDouble();
                        db.get(db.ReturnIndexElement(indexName), data);
                    }
                    else if(dataType.equalsIgnoreCase("Character")){
                        Character data = sc.next().charAt(0);
                        db.get(db.ReturnIndexElement(indexName), data);
                    }
                }
            }
            else if(command==4){
                //DISPLAY DATABASE
                db.display();
            }
            else if(command==5){
                //CLEAR
                db.clear();
            }
            else if(command==6){
                //VIEW HISTORY
                db.viewHistory();
            }
            else if(command==7){
                flag = false;
            }
        }
    }
}
