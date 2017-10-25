/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatm;

/**
 *
 * @author laurarogers
 */
public class ProjectATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create model Account Database: to be replaced by real database later.
        Database.accountDB.put("1234", new Account(2441, 24965.00));
        Database.accountDB.put("5678", new Account(9903, 125000.00));
        Database.accountDB.put("1357", new Account(1676, 4.00));
        Database.accountDB.put("2468", new Account(8732, 560.00));
        Database.accountDB.put("9991", new Account(6482, 1500.00));
        
    }
    
}
