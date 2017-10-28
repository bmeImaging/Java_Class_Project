
package projectatm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurarogers, acoats
 */
public class AccountTest {
    /**
     * Test of login method, of class Account.
     */
    @Test
    public void testLogin1() {
        System.out.println("login method tests empty string user input");
        String accNo = "";
        String pinNo = "";
        assertEquals("Invalid entries should return false",false, Account.login(accNo, pinNo));
    }

    @Test
    public void testLogin2() {
        System.out.println("login method tests incorrect PIN");
        String accNo = "12345";
        String pinNo = "11111";
        assertEquals("Invalid entries should return false",false, Account.login(accNo, pinNo));
    }
    
    @Test
    public void testLogin3() {
        System.out.println("login method tests incorrect PIN");
        String accNo = "12345";
        String pinNo = "24412";
        assertEquals("Invalid entries should return false",true, Account.login(accNo, pinNo));
    }
    
}
