package projectatm;


public class Account {
    //Account class contains constructor for our model account database and has 
    //1 method login(), which returns true if account is in database and PIN is 
    //correct.

    String PIN;
    double balance;

    public Account(String PIN, double balance) {
        this.PIN = PIN;
        this.balance = balance;
    }
    
    
    public static boolean login(String accNo, String pinNo) {
        //verifies account exists
        if (Database.accountDB.containsKey(accNo) == true) {
            if (Database.accountDB.get(accNo).PIN.equals(pinNo)) {
                return true;
            } else {
                System.out.println("PIN entry incorrect.");
                //return to prompt somehow
                return false;
            }   
        } else {
            System.out.println("This account does not exist");
            //return to appropriate account number entry prompt
            return false;
        }  
        
    }
    
}
