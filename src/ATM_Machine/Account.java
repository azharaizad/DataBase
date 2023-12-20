package ATM_Machine;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Account {
    private double id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated = new Date();
    private ArrayList<Transaction> list = new ArrayList<>();
    
    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0.1;
    }

    Account(double id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double getMonthlyInterest(){
        return balance*getMonthlyInterestRate();
    }

    public boolean withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            list.add(new Transaction("Withdraw", amount, balance, "RM"+amount+" withdrawn successfully.", dateCreated));
            return true;
        }
        else{
            list.add(new Transaction("Withdraw", amount, balance, "Withdrawn fail. Balance is not enough.", dateCreated));
            return false;
        }
    }

    public boolean deposit(double amount){
        balance+=amount;
        list.add(new Transaction("Deposit", amount, balance, "RM"+amount+" deposited successfully.", dateCreated));
 
        return true;
    }

    public void displayAccountActivity(){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
            System.out.println();
        }
    }
}
class testAccount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] arr = new Account[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Account(i,100); 
       }

       double userID = 0;
       int userActivity = 0;
       boolean flag = true;
       boolean idStatus = false;
       
       while (flag) {
            //User enter id
            
            while (!idStatus) {
                System.out.print("Enter user ID:");
                userID = sc.nextDouble();
                for (int i = 0; i < arr.length; i++) {
                    if(userID == arr[i].getId()){
                    idStatus = true;
                }
            }
                if(!idStatus)
                    System.out.println("Enter again!!");
                
            }
            //id is passed
            System.out.println("""
                    Main menu (-1 to Stop):
                    1. View balance
                    2. Withdraw
                    3. Deposit
                    4. Display Account History
                    5. Exit
                    """);
                
                userActivity = sc.nextInt();
                switch (userActivity) {
                    case 1:
                        System.out.println(arr[(int)userID].getBalance());
                        break;
                
                    case 2:
                    {
                        System.out.print("Enter amount:");
                        double amount = sc.nextDouble();
                        System.out.println(arr[(int)userID].withdraw(amount));
                        break;
                    }

                    case 3:
                    {
                        System.out.print("Enter amount:");
                        double amount = sc.nextDouble();
                        System.out.println(arr[(int)userID].deposit(amount));
                        break;
                    }

                    case 4:
                    {
                        arr[(int)userID].displayAccountActivity();
                        break;
                    }
                    case 5:
                        idStatus = false;
                        break;

                    default:
                        flag = false;
                        break;
                }
            }        
    }
}
