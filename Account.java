package projectatm;


public class Account {
    //Account class stores our model account database and has 1 method:
    //checkID, which returns true if account and matching PIN #s are in 
    //account database

    int accountNo;
    int PIN;
    double balance;

    
    
    public boolean checkID(int accNo, int pinNo) {
        if (accountNo == accNo && PIN == pinNo) {
            return true;
        } else {
            return false;
        }
    }
    
    public logIn() {
        
        if (checkID == true)
    }

    public Account(int accNo, int pinNo) {
        accountNo = accNo;
        PIN = pinNo;
    }

    /**
     * This constructor takes in all three parameters for the account and
     * assigns them to the class variables
     *
     * @param accNo = The account number for the account
     * @param pinNo = The PIN number for the account
     * @param balance = The initial balance for the account
     */
    public Account(int accNo, int pinNo, double balance) {
        accountNo = accNo;
        PIN = pinNo;
        this.balance = balance;
    }

    public int withdraw(int accNo, int pinNo, double amount) {
        if (checkID(accNo, pinNo)) {
            if (balance >= amount) {
                balance -= amount;
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public int deposit(int accNo, int pinNo, double amount) {
        if (checkID(accNo, pinNo)) {
            balance += amount;
            return 1;
        } else {
            return -1;
        }
    }

    public String showBalance(int accNo, int pinNo) {
        if (checkID(accNo, pinNo)) {
            return "Current balance: " + balance;
        } else {
            return "Invalid ID";
        }
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getPIN() {
        return PIN;
    }
}
