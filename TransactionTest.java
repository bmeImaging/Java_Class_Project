package projectatm;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {
	
	//Valid case, test menu option for case 1
    @Test
    public void testWithdraw1() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 1;
        assertEquals("Valid entries should return true",true, t.withdraw(accNo, wdMenuOption));
    }
    //Valid case, test menu option for case 2
    @Test
    public void testWithdraw2() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 2;
        assertEquals("Valid entries should return true",true, t.withdraw(accNo, wdMenuOption));
    }
    //Valid case, test menu option for case 3
    @Test
    public void testWithdraw3() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 3;
        assertEquals("Valid entries should return true",true, t.withdraw(accNo, wdMenuOption));
    }
    //Valid case, test menu option for case 4
    @Test
    public void testWithdraw4() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 4;
        assertEquals("Valid entries should return true",true, t.withdraw(accNo, wdMenuOption));
    }
    //Valid case, test menu option for case 5
    @Test
    public void testWithdraw5() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 5;
        assertEquals("Valid entries should return true",true, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, test menu option for case 6
    @Test
    public void testWithdraw6() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 6;
        assertEquals("Invalid entries should return false",false, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, invalid menu option
    @Test
    public void testWithdraw7() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 7;
        assertEquals("Invalid entries should return false",false, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, invalid ID
    @Test
    public void testWithdraw8() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "23487";
        int wdMenuOption = 1;
        assertEquals("Invalid entries should return false",false, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, insufficient funds in balance
    @Test
    public void testWithdraw9() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "00000";
        int wdMenuOption = 2;
        assertEquals("Invalid entries should return false",false, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, not enough bills in ATM
    @Test
    public void testWithdraw10() {
    	ATM.cashDispenser = 0;
    	Transaction t = new Transaction();
        String accNo = "12345";
        int wdMenuOption = 3;
        assertEquals("Invalid entries should return false",false, t.withdraw(accNo, wdMenuOption));
    }
    //Invalid case, invalid account number
    @Test
    public void testDeposit1() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "01010";
        double amount = 3000;
        boolean envelope = true;
        assertEquals("Invalid entries should return false",false, t.deposit(accNo, amount, envelope));
    }
    //Valid case, received an envelope
    @Test
    public void testDeposit2() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        double amount = 3000;
        boolean envelope = true;
        assertEquals("Valid entries should return true",true, t.deposit(accNo, amount, envelope));
    }
    //Invalid case, did not receive an envelope
    @Test
    public void testDeposit3() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        double amount = 3000;
        boolean envelope = false;
        assertEquals("Invalid entries should return false",false, t.deposit(accNo, amount, envelope));
    }
    //Invalid case, account number incorrect
    @Test
    public void testBalanceInquiry1() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12346";
        assertEquals("Invalid entries should return false",false, t.balanceInquiry(accNo));
    }
    //Valid case, account number correct
    @Test
    public void testBalanceInquiry2() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        String accNo = "12345";
        assertEquals("Valid entries should return true",true, t.balanceInquiry(accNo));
    }
    //Truncating decimals
    @Test
    public void testFormat1() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
    	double balance = 2345.651851324;
        assertEquals("Results should have two decimal points","2345.65", t.format(balance));
    }
    //Adding decimals to integer
    @Test
    public void testFormat2() {
    	ATM.cashDispenser = 500;
    	Transaction t = new Transaction();
        double balance = 8347;
        assertEquals("Results should have two decimal points","8347.00", t.format(balance));
    }

}
