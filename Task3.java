/*Oasis infobyte 
  java Task 3
  ATM interface */


import java.util.Scanner; 
  
 class BankAccount { 
          
         String Name; 
         String UserName; 
         String Password; 
         String AccountNumber; 
         float Balance = 1000f; 
         int Transactions = 0; 
         String TransactionHistory = ""; 
          

          
         public void register() { 
                 Scanner sc = new Scanner(System.in); 
                 System.out.print("\nEnter Your Name - "); 
                 Name = sc.nextLine(); 
                 System.out.print("\nEnter Your Username - "); 
                 UserName = sc.nextLine(); 
                 System.out.print("\nEnter Your Password - "); 
                 Password = sc.nextLine(); 
                 System.out.print("\nEnter Your Account Number - "); 
                 AccountNumber = sc.nextLine(); 
                 System.out.println("\nRegistration completed..kindly login"); 
         } 
         public boolean login() { 
            boolean isLogin = false; 
            Scanner sc = new Scanner(System.in); 
            while ( !isLogin ) { 
                    System.out.print("\nEnter Your Username - "); 
                    String Username = sc.nextLine(); 
                    if ( Username.equals(UserName) ) { 
                            while ( !isLogin ) { 
                                    System.out.print("\nEnter Your Password - "); 
                                    String Password = sc.nextLine(); 
                                    if ( Password.equals(Password) ) { 
                                            System.out.print("\nLogin successful!!"); 
                                            isLogin = true; 
                                    } 
                                    else { 
                                            System.out.println("\nIncorrect Password"); 
                                    } 
                            } 
                    } 
                    else { 
                            System.out.println("\nUsername not found"); 
                    } 
            } 
            return isLogin; 
    } 
    public void withdraw() { 
                  
        System.out.print("\nEnter amount to withdraw - "); 
        Scanner sc = new Scanner(System.in); 
        float amount = sc.nextFloat(); 
        try { 
                 
                if ( Balance >= amount ) { 
                        Transactions++; 
                        Balance -= amount; 
                        System.out.println("\nWithdraw Successfully"); 
                        String str = amount + " Rs Withdrawed\n"; 
                        TransactionHistory = TransactionHistory.concat(str); 
                         
                } 
                else { 
                        System.out.println("\nInsufficient Balance"); 
                } 
                 
        } 
        catch ( Exception e) { 
        } 
} 
 
public void deposit() { 
         
        System.out.print("\nEnter amount to deposit - "); 
        Scanner sc = new Scanner(System.in); 
        float amount = sc.nextFloat(); 
        try { 
            if ( amount <= 1000f ) { 
                    Transactions++; 
                    Balance += amount; 
                    System.out.println("\nSuccessfully Deposited"); 
                    String str = amount + " Rs deposited\n"; 
                    TransactionHistory = TransactionHistory.concat(str); 
            } 
            else { 
                    System.out.println("\nSorry...Limit is 100000.00"); 
            } 
             
    } 
    catch ( Exception e) { 
    } 
} 

public void transfer() { 
     
    Scanner sc = new Scanner(System.in); 
    System.out.print("\nEnter Receipent's Name - "); 
    String Receipent = sc.nextLine(); 
    System.out.print("\nEnter amount to transfer - "); 
    float Amount = sc.nextFloat(); 
    try { 
        if ( Balance >= Amount ) { 
                if ( Amount <= 500f ) { 
                        Transactions++; 
                        Balance -= Amount; 
                        System.out.println("\nSuccessfully Transfered to " + Receipent); 
                        String str = Amount + " Rs transfered to " + Receipent + "\n"; 
                        TransactionHistory = TransactionHistory.concat(str); 
                } 
                else { 
                        System.out.println("\nSorry...Limit is 50000.00"); 
                } 
        } 
        else { 
                System.out.println("\nInsufficient Balance"); 
        } 
} 
catch ( Exception e) { 
} 
} 

public void checkBalance() { 
System.out.println("\n" + Balance + " Rs"); 
} 

public void transHistory() { 
if ( Transactions == 0 ) { 
        System.out.println("\nEmpty"); 
} 
else { 
    System.out.println("\n" + TransactionHistory); 
} 
} 
} 


public class Task3 { 


public static int takeIntegerInput(int limit) { 
int input = 0; 
boolean flag = false; 

while ( !flag ) { 
    try { 
            Scanner sc = new Scanner(System.in); 
            input = sc.nextInt(); 
            flag = true; 
             
            if ( flag && input > limit || input < 1 ) { 
                    System.out.println("Choose the number between 1 to " + limit); 
                    flag = false; 
            } 
    } 
    catch ( Exception e ) { 
            System.out.println("Enter only integer value"); 
            flag = false; 
    } 
}; 
return input; 
} 
public static void main(String[] args) { 
                  
    System.out.println("\nWELCOME TO SBI ATM\n"); 
    System.out.println("1.Register  \n2.Exit"); 
    System.out.print("Enter Your Choice - "); 
    int choice = takeIntegerInput(2); 
     
    if ( choice == 1 ) { 
            BankAccount b = new BankAccount(); 
            b.register(); 
            while(true) { 
                    System.out.println("\n1.Login \n2.Exit"); 
                    System.out.print("Enter Your Choice - "); 
                    int ch = takeIntegerInput(2); 
                    if ( ch == 1 ) { 
                            if (b.login()) { 
                                    System.out.println("\n\nWELCOME BACK " + b.Name + "\n"); 
                                    boolean isFinished = false; 
                                    while (!isFinished) { 
                                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit"); 
                                            System.out.print("\nEnter Your Choice - "); 
                                            int c = takeIntegerInput(6); 
                                            switch(c) { 
                                                case 1: 
                                                b.withdraw(); 
                                                break; 
                                                case 2: 
                                                b.deposit(); 
                                                break; 
                                                case 3: 
                                                b.transfer(); 
                                                break; 
                                                case 4: 
                                                b.checkBalance(); 
                                                break; 
                                                case 5: 
                                                b.transHistory(); 
                                                break; 
                                                case 6: 
                                                isFinished = true; 
                                                break; 
                                        } 
                                } 
                        } 
                } 
                else { 
                        System.exit(0); 
                } 
        } 
} 
else { 
        System.exit(0); 
} 
 
 

}
}
