
package projectatm;

/**
 *
 * @author laurarogers
 */
public class ATM {
    static int cashDispenser;
    static boolean depositSlot;
    static int keypad;
            
    
    public ATM() {
        cashDispenser = 500; //reloaded with 500 $20's each day.
        depositSlot = false; //if user inserts an envelope, turns true.
    }
    
    public void resetATM() {
        UserInterface.loggedIn = false;
        UserInterface.pinNo = "PIN not indicated";
        UserInterface.accNo = "Account not indicated";
        depositSlot = false;
        UserInterface.amount = 0;
        UserInterface.choice = 0;
    }
}
