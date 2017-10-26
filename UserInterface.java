package projectatm;

import java.util.Scanner;

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
                String accNo = kb.next();
                //Add in quality control for account number entry
                System.out.print("Please enter your 5-digit PIN:");
                String pinNo = kb.next();
                //Add in quality control for account number entry
                //PIN check and log in
                loggedIn = Account.login(accNo, pinNo);
                if (!loggedIn) {
                    System.out.println("Login failed. Please try again.");
                    //Program returns to start of inner while loop.
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
                    System.out.println("How much would you like to deposit?\n"
                            + "Deposits should be entered without a decimal. "
                            + "For example, $57.60 is entered 5760.");
                    double depAmount = kb.nextDouble();
                    Transaction deposit = new Transaction();
                    deposit.deposit(accNo, depAmount);
                    break;
                case 4:  //user chose to exit system
                    System.out.println("Transaction cancelled.");
                    break;
                default:
                    break;
            }

//                kb.close();  //Is this needed?
            //Introduce brief pause and return to start of outer while loop.
            atm.resetATM();
        }
    }
}
