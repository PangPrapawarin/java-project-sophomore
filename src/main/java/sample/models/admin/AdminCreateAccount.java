package sample.models.admin;

import sample.models.CreateAccounts;

public class AdminCreateAccount extends CreateAccounts {
    public AdminCreateAccount(String username, String password, String confirmPassword) {
        super(username, password, confirmPassword);
    }

}
