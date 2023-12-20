package ATM_Machine;

import java.util.Date;

public class Transaction {
    private String typeTransaction;
    private double amountTransaction;
    private double balance;
    private String description;
    private Date dateActivity;

    Transaction(String typeTransaction,double amountTransaction,double balance,String description, Date dateActivity){
        this.typeTransaction = typeTransaction;
        this.amountTransaction = amountTransaction;
        this.balance = balance;
        this.description = description;
        this.dateActivity = dateActivity;
    }

    public void display(){
        System.out.println("Type of transaction: "+typeTransaction+" ("+dateActivity+")");
        System.out.println("Transaction amount: "+amountTransaction);
        System.out.println("Balance: "+balance);
        System.out.println("Description: "+description);
    }
}

