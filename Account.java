package projectatm;


public class Account {
    //Account class contains constructor for our model account database and has 
    //1 method login(), which returns true if account is in database and PIN is 
    //correct.

    int PIN;
    double balance;

    public Account(int PIN, double balance) {
        this.PIN = PIN;
        this.balance = balance;
    }
    
    
    public boolean login(int accNo, int pinNo) {
        //verifies account exists
        if (Database.accountDB.containsKey(accNo) == true) {
            if (Database.accountDB.get(accNo) == pinNo) {
                return true;
            } else {
                System.out.println("PIN entry incorrect.");
                //return to prompt somehow
            }
            
            
        } else {
            System.out.println("This account does not exist");
            //return to appropriate account number entry prompt
            return false;
        }
        //checks PIN entry against database for account
        if (Account.thisAccount.PIN == pinNo) {
            return true;
        } else {
            return false;
        }
    }
    
}
