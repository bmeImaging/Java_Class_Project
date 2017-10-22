import java.util.Scanner;

public class Interface 
{
	
	public static void main(String[] args) 
	{
		int accountNo;
		int pinNo;
		boolean loggedIn = false;
		int choice = 0;
		int amount;
		
		ATM atm = new ATM();
		Scanner kb = new Scanner(System.in);
		while(true) //Main loop of the program that contains the user interface
		{
			while (!loggedIn) //This loop forces the user to log in
			{
				System.out.println("Options: \n" + "1 - Login\n" + "2 - Quit");
				choice = kb.nextInt();
				if(choice == 1) //User chose to log in
				{
					System.out.print("Please enter you account number: ");
					accountNo = kb.nextInt();
					System.out.print("Please enter you PIN number: ");
					pinNo = kb.nextInt();
					loggedIn = atm.login(accountNo, pinNo); 
					if(!loggedIn) //User credentials were incorrect
						System.out.println("Credentials incorrect, please try again.");
					else
						System.out.println("Successfully logged in.");
				}
				else if(choice == 2) //user chose to quit the program
				{
					kb.close();
					System.out.println("Terminating program...");
					System.exit(0);
				}
				else //User supplies incorrect input
				{
					System.out.println("Invalid input, please try again.");
				}
			}
			
			
			System.out.println("What would you like to do?\n" + "1 - Make a withdrawl\n" + 
					           "2 - Make a deposit\n" + "3 - Check your balance\n" + "4 - Log out");

			choice = kb.nextInt();
			
			if(choice == 1) //User chose to withdraw
			{
				System.out.println("How much would you like to withdraw?\n\n" + "Withdrawls must be multiples of twenty.");
				amount = kb.nextInt();
				String response = atm.withdraw(amount);
				System.out.println(response);
				System.out.println(atm.dispenseCash(amount)); //Once the withdraw method is implemented in ATM class this line will be removed
			}
			
			else if(choice == 2) //User chose to deposit
			{
				System.out.println("How much would you like to deposit?\n\n" + "Deposits are to be given in cents.");
				amount = kb.nextInt();
				System.out.println(atm.insertDeposit()); //Once the deposit method is implemented in ATM class this line will be removed
				String response = atm.deposit(amount);
				System.out.println(response);
			}
			
			else if(choice == 3) //User chose to check balance
			{
				String response = atm.showBalance();
				System.out.println(response);
			}
			
			else if(choice == 4) //User chose to log out
			{
				System.out.println("Logging out...");
				loggedIn = (!atm.logout());
				if(loggedIn) //Checks to make sure the log out was successful
				{
					System.out.println("Unable to log out. Terminating program...");
					kb.close();
					System.exit(1);
				}
			}
			
			else //User supplies incorrect input
			{
				System.out.println("Invalid input, please try again.");
			}
		}
	}

}
