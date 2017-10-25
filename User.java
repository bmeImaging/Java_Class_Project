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
public class User {
    //At login, user object is created and balance is retrieved from Account class
    
    double balance;
    
    public User(Account x) {this.balance = x.balance; }
  
}
