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

    public double withdraw(User a, int wdMenuOption) { 
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
                    return a.balance;
        }
        
        if (amount <= a.balance && ATM.cashDispenser >= amount/20.00) {
            a.balance -= amount;
            ATM.cashDispenser -= amount/20.00; 
            System.out.println("Cash dispensed. Please take money.\n"
                    + "Account balance: " + a.balance);
        } else if (amount > a.balance) {
            System.out.println("Insufficient funds in account to process request.");
            //return to interface prompt somehow.
        } else if (amount/20.00 > ATM.cashDispenser) {
            System.out.println("Request exceeds ATM funds. Please try a smaller amount.");
            //return to step1 of interface prompt somehow.
        }
        //return to main menu after brief pause.
        return a.balance;
    }
    
    public double deposit(User a, double amount) {
        //amount in the case is input passed from user interface and is formatted
        //as 2745 for $27.45
        
        if (amount <= 0) {
            System.out.println("Transaction cancelled.");
            //return to main menu somehow. Don't know what return is needed.
            return a.balance;
        } else {
            System.out.println("Please insert deposit envelope.");
            ATM.depositSlot = true; //extra credit involves this.     
            a.balance += amount / 100; //will there be issues with passing an int as a double?
            System.out.println("Amount deposited: " + amount/100 +
                    "\nAccount balance: " + a.balance);

            //return to main menu after brief pause.
            return a.balance;
        }
        
    }
    
    public double balanceInquiry(User a) { 
        System.out.println("Account balance: " + a.balance);
        return a.balance; 
    } 
        
}
