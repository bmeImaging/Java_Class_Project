
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
    //which takes inputs  int PIN (5 digits) and double balance (5 digits).
    static Map<String, Account> accountDB = new HashMap<>();

    static {
        accountDB.put("12345", new Account("24412", 24965.70));
        accountDB.put("56789", new Account("99038", 125000.00));
        accountDB.put("13575", new Account("16768", 4.35));
        accountDB.put("24686", new Account("87324", 560.04));
        accountDB.put("99918", new Account("64827", 1500.96));
    }
}
