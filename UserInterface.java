package projectatm;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInterface {

    static boolean loggedIn = false;
    static int choice;
    static int amount;
    static String accNo;
    static String pinNo;

    public static void main(String[] args) {
        //Instantiate ATM
        ATM atm = new ATM();
        Scanner kb = new Scanner(System.in);

        //Begin main loop of program 
        while (true) {

            while (!loggedIn) {
                //This loop forces the user to log in
                System.out.println("Welcome!\nPlease enter your 5-digit account number:");
                accNo = kb.next();
                //Add in quality control for account number entry
                System.out.print("Please enter your 5-digit PIN:");
                pinNo = kb.next();
                //Add in quality control for account number entry
                //PIN check and log in
                loggedIn = Account.login(accNo, pinNo);
                if (!loggedIn) {
                    System.out.println("Login failed. Please try again.");
                    //Introduce brief pause and return to welcome menu.
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            //Once logged in, prompt for user activity
            System.out.println("Select transaction type:\n" + "1 - Check balance\n"
                    + "2 - Withdrawal\n" + "3 - Deposit\n" + "4 - Exit system");
            choice = kb.nextInt();

            switch (choice) {
                case 1:  //User chose to check balance
                    Transaction checkBalance = new Transaction();
                    checkBalance.balanceInquiry(accNo);
                    break;

                case 2:  //User chose to make a withdrawal
                    Transaction withdrawal = new Transaction();
                    while (withdrawal.withdrawReturn == false) {
                        System.out.println("Choose withdrawal amount:\n1 - $20.00\n2 - $40.00\n"
                                + "3 - $60.00\n4 - $100.00\n5 - $200.00\n6 - Cancel transaction");
                        int wdMenuOption = kb.nextInt();
                        withdrawal.withdraw(accNo, wdMenuOption);
                    }
                    break;

                case 3:  //user chose to make a deposit
                    System.out.println("Please enter deposit amount without a decimal.\n"
                            + "For example, $57.60 is entered 5760.");
                    double depAmount = kb.nextDouble();
                    if (depAmount <= 0) {
                        System.out.println("Transaction cancelled.");
                        break;
                    } else {
                        Transaction deposit = new Transaction();
                        System.out.println("Please insert deposit envelope.");
                        boolean envelope = atm.isEnvelope();
                        deposit.deposit(accNo, depAmount, envelope);
                        break;
                    }

                case 4:  //user chose to exit system
                    System.out.println("Transaction cancelled.\nThank you.");
                    break;

                default: //user entered something other than 1-4.
                    System.out.println("Invalid entry.");
                    continue;
            }

            //Introduce brief pause and return to start of outer while loop.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            atm.resetATM();
        }
    }
}
