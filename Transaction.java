/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatm;

/**
 *
 * @author laurarogers
 */
public class Transaction {
    //Transaction class contains code for withdraw, deposit and balance inquiry
    //methods called from the UserInterface class.

    double amount;
    boolean withdrawReturn = false;
    

    public void withdraw(String accNo, int wdMenuOption) { 
        //additional prompt for wdMenuOption chosen thru user interface or here?
        switch (wdMenuOption) {
            case 1: amount = 20.00;
                    break;
            case 2: amount = 40.00;
                    break;
            case 3: amount = 60.00;
                    break;
            case 4: amount = 100.00;
                    break;
            case 5: amount = 200.00;
                    break;
            case 6: System.out.println("Transaction cancelled.");
                    //return to main menu
//                    return Database.accountDB.get(accNo).balance;
        }
        
        
        if (amount <= Database.accountDB.get(accNo).balance && 
                ATM.cashDispenser >= amount/20.00) {
            Database.accountDB.get(accNo).balance -= amount;
            ATM.cashDispenser -= amount/20.00;
            withdrawReturn = true;
            System.out.println("Cash dispensed. Please take money.\n"
                    + "Account balance: " + Database.accountDB.get(accNo).balance);
        } else if (amount > Database.accountDB.get(accNo).balance) {
            System.out.println("Insufficient funds in account to process request.\n"
            + "Please enter a smaller amount.");
            withdrawReturn = false;
        } else if (amount/20.00 > ATM.cashDispenser) {
            System.out.println("Request exceeds ATM funds. Please enter a smaller amount.");
            withdrawReturn = false;
        }
        //return to main menu after brief pause.
        
        //    UserInterface.loggedIn = false;
    }
        
    
    public void deposit(String accNo, double amount) {
        //amount in the case is input passed from user interface and is formatted
        //as 2745 for $27.45
        
        if (amount <= 0) {
            System.out.println("Transaction cancelled.");
            //return to main menu somehow. Don't know what return is needed.
            return Database.accountDB.get(accNo).balance;
        } else {
            System.out.println("Please insert deposit envelope.");
            ATM.depositSlot = true; //extra credit involves this.     
            Database.accountDB.get(accNo).balance += amount / 100; 
            System.out.println("Amount deposited: " + amount/100 +
                    "\nAccount balance: " + Database.accountDB.get(accNo).balance);

            //return to main menu after brief pause.
//            return a.balance;
        }
        
    }
    
    public void balanceInquiry(String accNo) { 
        System.out.println("Account balance: " + Database.accountDB.get(accNo).balance);
    } 
        
}
