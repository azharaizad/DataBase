/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database_Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author aizad
 */
public class Jframe extends javax.swing.JFrame implements ActionListener{
    
    JTextPane Welcome,DataTypePane,NumberofDataPane;
    JTextField Command,txtNumberofData,txtInsert,txtIndexName,txtDataType,txtData;
    JButton Enter,Back,Submit;
    Database db;
    JLabel Message,InsertLabel,IndexNameLabel,DataLabel;
    
    //MainPage
    
    public Jframe(){
        super("Welcome to G26 Database!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        db = new Database();
        
        setSize(500,600);
        setVisible(true);
        MainLayout();
    }
            
    
    public void MainLayout(){
        
        getContentPane().removeAll();
        setLayout(new FlowLayout(FlowLayout.LEFT,50,30));
        Message = new JLabel("");
        Welcome = new JTextPane();
        Welcome.setEditable(false);
        Welcome.setText("""
                        Choose your command (Enter Integer):
                         1. INSERT - Insert new data/index
                         2. DELETE - Delete specific data/index
                         3. GET -  Retrieve specific data/index
                         4. DISPLAY DATABASE - Display the whole database
                         5. CLEAR - Clear all data
                         6. HISTORY - View past action
                         7. CLOSE - End program
                             """);
        
        Command = new JTextField(10);
        Enter = new JButton("ENTER");
        add(Welcome);
        add(Command);
        
        Enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //Insert Logic
                int x = Integer.parseInt(Command.getText());
                getContentPane().remove(Message);
                switch(x){
                    case 1 -> InsertLayout();
                    case 2 -> DeleteLayout();
                    case 3 -> GetLayout();
                    case 4 -> db.display();
                    case 5 ->  {
                        db.clear();
                        Message.setText("Clear All!!");
                        add(Message);
                        revalidate();
                        repaint();
                    }
                    case 6 -> db.viewHistory();
                    case 7 -> System.exit(0);
                    default ->  {
                        Message.setText("Wrong Command!!");
                        add(Message);
                        revalidate();
                        repaint();
                    }
                }
            }  
        });
        
        add(Enter);
        revalidate();
        repaint();
    }
    
    public void InsertLayout(){
        
        DataTypePane = new JTextPane();
        DataTypePane.setEditable(false);
        DataTypePane.setText("""
                            Choose data type(Int):
                            1. STRING
                            2. INTEGER
                            3. DOUBLE
                            4. CHARACTER
                            """);
        txtDataType = new JTextField(10);
        
        NumberofDataPane = new JTextPane();
        NumberofDataPane.setEditable(false);
        NumberofDataPane.setText("""
                                 Number of Data(Int):
                                 1. Single
                                 2. Collection
                                 """);
        txtNumberofData = new JTextField(10);
        
        InsertLabel = new JLabel("Value(Split by Coma):");
       // InsertLabel.setText("");
        txtInsert = new JTextField(10);
        
        IndexNameLabel = new JLabel("Enter Index Name:");
        //IndexNameLabel.setText("Index Name");
        txtIndexName = new JTextField(10);
        
        Back = new JButton("Back");
        Submit = new JButton("Submit");
        
        getContentPane().removeAll();
        setLayout(null);
        //x,y,width,weight
        DataTypePane.setBounds(10, 10, 200, 100);
        txtDataType.setBounds(220, 10, 150, 20);
    
        NumberofDataPane.setBounds(10, 130, 200, 80);
        txtNumberofData.setBounds(220, 130, 150, 20);
    
        InsertLabel.setBounds(10, 220, 150, 20);
        txtInsert.setBounds(220, 220, 150, 20);
    
        IndexNameLabel.setBounds(10, 260, 150, 20);
        txtIndexName.setBounds(220, 260, 150, 20);
        
        Submit.setBounds(10, 300, 80, 30);
        Back.setBounds(100, 300, 80, 30);
    
        add(DataTypePane);
        add(txtDataType);
        add(NumberofDataPane);
        add(txtNumberofData);
        add(InsertLabel);
        add(txtInsert);
        add(IndexNameLabel);
        add(txtIndexName);
        
        //Submit Button
        Submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //Insert Logic
                int x = Integer.parseInt(txtNumberofData.getText());
                int dataType = Integer.parseInt(txtDataType.getText());
                
                //single value
                if(x==1){
                    switch(dataType){
                        case 1:{
                            MyLinkedList<String> StringIndex = new MyLinkedList<>("String");
                            StringIndex.ListName = txtIndexName.getText();
                            db.insert(StringIndex, txtInsert.getText());
                            break;
                        }
                        case 2:{
                            MyLinkedList<Integer> IntegerIndex = new MyLinkedList<>("Integer");
                            IntegerIndex.ListName = txtIndexName.getText();
                            db.insert(IntegerIndex, txtInsert.getText());
                            break;
                        }
                        case 3:{
                            MyLinkedList<Double> DoubleIndex = new MyLinkedList<>("Double");
                            DoubleIndex.ListName = txtIndexName.getText();
                            db.insert(DoubleIndex, txtInsert.getText());
                            break;
                        }
                        case 4:{
                            MyLinkedList<Character> CharacterIndex = new MyLinkedList<>("Character");
                            CharacterIndex.ListName = txtIndexName.getText();
                            db.insert(CharacterIndex, txtInsert.getText());
                            break;
                        }
                    }
                }
                else{
                    switch(dataType){
                            case 1:{
                                MyLinkedList<String> StringIndex = new MyLinkedList<>("String");
                                StringIndex.ListName = txtIndexName.getText();
                                String[] ArrayValue = txtInsert.getText().split(",");
                                db.insertMany(StringIndex, ArrayValue);
                                break;
                            }
                            case 2:{
                                MyLinkedList<String> IntegerIndex = new MyLinkedList<>("Integer");
                                IntegerIndex.ListName = txtIndexName.getText();
                                String[] strArrayValue = txtInsert.getText().split(",");
                                db.insertMany(IntegerIndex, strArrayValue);
                                break;
                            }
                            case 3:{
                                MyLinkedList<String> DoubleIndex = new MyLinkedList<>("Double");
                                DoubleIndex.ListName = txtIndexName.getText();
                                String[] strArrayValue = txtInsert.getText().split(",");
                                db.insertMany(DoubleIndex,strArrayValue);
                                break;
                            }
                            case 4:{
                                MyLinkedList<String> CharacterIndex = new MyLinkedList<>("Character");
                                CharacterIndex.ListName = txtIndexName.getText();
                                String[] strArrayValue = txtInsert.getText().split(",");
                                db.insertMany(CharacterIndex,strArrayValue);
                                break;
                            }
                    }
                }
                Message.setText("[Added]");
                Message.setBounds(10,400, 150, 20);
                add(Message);
                revalidate();
                repaint();
            }
        });
        add(Submit);
        
        
        //Back Button
        Back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //Insert Logic
                MainLayout();
            }  
        });
        add(Back);
        
        
        revalidate();
        repaint();
    }
    
    public void DeleteLayout(){
        
        db.display();
        
        IndexNameLabel = new JLabel("Enter your Index Name: ");
        txtIndexName = new JTextField(10);
        
        DataLabel = new JLabel("Enter your Data");
        txtData = new JTextField(10);
        
        Back = new JButton("Back");
        Submit = new JButton("Submit");
        
        getContentPane().removeAll();
        setLayout(null);
        
        IndexNameLabel.setBounds(10, 10, 150, 20);
        txtIndexName.setBounds(180, 10, 150, 20);
    
        DataLabel.setBounds(10, 60, 150, 20);
        txtData.setBounds(180, 60, 150, 20);
        
        Submit.setBounds(10, 300, 80, 30);
        Back.setBounds(100, 300, 80, 30);
        
        add(IndexNameLabel);
        add(txtIndexName);
        add(DataLabel);
        add(txtData);
        
        Submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtData.getText().equals("")){
                    db.deleteData(db.ReturnIndexElement(txtIndexName.getText()),txtData.getText());
                }
                else{
                    db.deleteIndex(db.ReturnIndexElement(txtIndexName.getText()));
                }
                Message.setText("[Deleted]");
                Message.setBounds(10,100, 150, 20);
                add(Message);
                revalidate();
                repaint();
            }
        });
        add(Submit);
        
        Back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //Insert Logic
                MainLayout();
            }  
        });
                
       add(Back);
       revalidate();
       repaint();
    }
    
    public void GetLayout(){
        
        db.display();
        
        IndexNameLabel = new JLabel("Enter your Index Name: ");
        txtIndexName = new JTextField(10);
        
        DataLabel = new JLabel("Enter your Data");
        txtData = new JTextField(10);
        
        Back = new JButton("Back");
        Submit = new JButton("Submit");
        
        getContentPane().removeAll();
        setLayout(null);
        
        IndexNameLabel.setBounds(10, 10, 150, 20);
        txtIndexName.setBounds(180, 10, 150, 20);
    
        DataLabel.setBounds(10, 60, 150, 20);
        txtData.setBounds(180, 60, 150, 20);
        
        Submit.setBounds(10, 300, 80, 30);
        Back.setBounds(100, 300, 80, 30);
         
        getContentPane().removeAll();
        
        add(IndexNameLabel);
        add(txtIndexName);
        add(DataLabel);
        add(txtData);
        
        Submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtData.getText().equals("")){
                    db.get(db.ReturnIndexElement(txtIndexName.getText()),txtData.getText());
                }
                else{
                    db.get(db.ReturnIndexElement(txtIndexName.getText()),null);
                }  
            }
        });
        add(Submit);
        
        Back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            //Insert Logic
                MainLayout();
            }  
        });
                
        add(Back);
        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        new Jframe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
