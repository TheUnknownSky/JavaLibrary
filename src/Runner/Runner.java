package Runner;

import GUI.Registration;
import GUI.Login;
import Account.Account;

public class Runner {
    public static void main(String[] args) {
        Account acct = new Account();
        if (acct.getRowCountOfUsers() == 0){
            new Registration().setVisible(true);
        } else {
            new Login().setVisible(true);
        }
    }
}
