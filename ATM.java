
package projectatm;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        depositSlot = false; 
    }
    
    public boolean isEnvelope() {
        //Method checks whether envelope is deposited. 
        //Always returns true after brief pause, extra credit not attempted.
        try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        depositSlot = true;
        return (true);
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
