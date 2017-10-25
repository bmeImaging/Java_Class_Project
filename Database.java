
package projectatm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laurarogers
 */
public class Database {

    //Constructor used to model account database is called in Main.
    //String key in this case is the account number. Value is the Account object,
    //which takes inputs  int PIN and double balance.
    static Map<String, Account> accountDB = new HashMap<>();

    static {
        accountDB.put("1234", new Account(2441, 24965.70));
        accountDB.put("5678", new Account(9903, 125000.00));
        accountDB.put("1357", new Account(1676, 4.35));
        accountDB.put("2468", new Account(8732, 560.04));
        accountDB.put("9991", new Account(6482, 1500.96));
    }
}
