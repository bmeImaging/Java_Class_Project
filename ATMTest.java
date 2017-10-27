/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurarogers
 */
public class ATMTest {
    
    public int getCashDispenser() { return ATM.cashDispenser; }
    public boolean getDepositSlot() { return ATM.depositSlot; }
        
    public ATMTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println(System.getProperty("java.class.path"));
    }
        
    @Before
    public void setUp() {
        ATM testInstance = new ATM();
    }

    /**
     * Tests of ATM constructor, of class ATM.
     */
    @Test
    public void shouldInitializeWith500Twenties() {
        System.out.println("Is initialized with 500 twenties");
        ATM testInstance = new ATM();
        assertEquals("Should initialize with 500 20's",500,getCashDispenser());       
    }
    
    @Test
    public void shouldInitializeDepositSlottoFalse() {
        System.out.println("Deposit slot is initialized to false");
        ATM testInstance = new ATM();
        assertEquals("Should initialize to false",false,getDepositSlot());       
    }
    
    /**
     * Test of isEnvelope method, of class ATM.
     */
    @Test
    public void testIsEnvelope() {
        System.out.println("isEnvelope");
        ATM testInstance = new ATM();
        assertEquals("isEnvelope was supposed to return true", true, testInstance.isEnvelope());
    }

    /**
     * Test of screenPause method, of class ATM.
     */
    @Test
    public void testScreenPause() {
        System.out.println("screenPause");
        ATM testInstance = new ATM();
        testInstance.screenPause();
    }

    /**
     * Test of resetATM method, of class ATM.
     */
    @Test
    public void testResetATM() {
        System.out.println("resetATM");
        ATM testInstance = new ATM();
        assertEquals("depositSlot should return false", false, testInstance.depositSlot);
        assertEquals("loggedIn should return false", false, UserInterface.loggedIn);
        assertEquals("amount should be 0",0, UserInterface.amount);
        assertEquals("choice should be 0",0, UserInterface.choice);
    }
    
}
