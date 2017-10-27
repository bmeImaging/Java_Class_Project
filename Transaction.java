/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatm;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;

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
            case 1:
                amount = 20.00;
                break;
            case 2:
                amount = 40.00;
                break;
            case 3:
                amount = 60.00;
                break;
            case 4:
                amount = 100.00;
                break;
            case 5:
                amount = 200.00;
                break;
            case 6:
                amount = 0.00;
                break;
            default:
                amount = 0.00;
                System.out.println("Invalid entry. Please choose from options 1-6.");
                break;
        }

        if (amount == 0.00) {
            System.out.println("Transaction cancelled.");
            withdrawReturn = true;
        } else if (amount <= Database.accountDB.get(accNo).balance
                && ATM.cashDispenser >= amount / 20.00) {
            Database.accountDB.get(accNo).balance -= amount;
            ATM.cashDispenser -= amount / 20.00;
            withdrawReturn = true;
            System.out.println("Thank you.\nCash dispensed, please take money.\n"
                    + "Account balance: " + format(Database.accountDB.get(accNo).balance));
        } else if (amount > Database.accountDB.get(accNo).balance) {
            System.out.println("Insufficient funds in account to process request.\n"
                    + "Please enter a smaller amount.");
        } else if (amount / 20.00 > ATM.cashDispenser) {
            System.out.println("Request exceeds ATM funds. Please enter a smaller amount.");
        }
    }

    public void deposit(String accNo, double amount, boolean envelope) {
        //amount input passed from user interface is formatted as 2745 for $27.45
        if (envelope == true) { //extra credit option here
            Database.accountDB.get(accNo).balance += amount / 100;
            System.out.println("Thank you.\nAmount deposited: " + amount / 100
                    + "\nAccount balance: " + format(Database.accountDB.get(accNo).balance));
        } else {
            System.out.println("No envelope received. Transaction cancelled.");
        }
    }

    public void balanceInquiry(String accNo) {
        System.out.println("Account balance: " + format(Database.accountDB.get(accNo).balance));
    }

    public String format(double balance) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(balance);
    }

}
