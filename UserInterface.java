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
        UserInterface session = new UserInterface();

        //Begin main loop of program by calling user interface 
        Scanner kb = new Scanner(System.in);
        while (true) {
            while (!loggedIn) { //This loop forces the user to log in
                System.out.println("Welcome!\nPlease enter your 5-digit account number:");
                String accNo = kb.next();
                //Add in quality control for account number entry
                System.out.print("Please enter your 5-digit PIN:");
                String pinNo = kb.next();
                //Add in quality control for account number entry

                loggedIn = Account.login(accNo, pinNo);
                if (!loggedIn) { //Login failed
                    System.out.println("Login failed. Please try again.");
                }
            }

            System.out.println("Select transaction type:\n" + "1 - Check balance\n"
                    + "2 - Make a withdrawal\n" + "3 - Make a deposit\n" + "4 - Exit system");

            choice = kb.nextInt();

            if (choice == 1) {  //User chose to check balance
                Transaction checkBalance = new Transaction();
                checkBalance.balanceInquiry(accNo);
            } else if (choice == 2) { //User chose to make a withdrawal
                Transaction withdrawal = new Transaction();
                while (withdrawal.withdrawReturn == false) {
                    System.out.println("Choose withdrawal amount:\n1 - $20.00\n2 - $40.00\n"
                            + "3 - $60.00\n4 - $100.00\n5 - $200.00\n6 - Cancel transaction");
                    int wdMenuOption = kb.nextInt();
                    withdrawal.withdraw(accNo, wdMenuOption);
                }
            } else if (choice == 3) { //use chose to make a deposit
                System.out.println("How much would you like to deposit?\n\n"
                        + "Deposits are to be given in cents.");
                double amount = kb.nextDouble();
                Transaction deposit = new Transaction();
                deposit.deposit(accNo, amount);
            } else if (choice == 4) { //user chose "exit system"
                kb.close();
                System.exit(0);
            }
