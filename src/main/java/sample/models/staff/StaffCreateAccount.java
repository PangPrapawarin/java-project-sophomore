package sample.models.staff;

import sample.models.CreateAccounts;

public class StaffCreateAccount extends CreateAccounts {
    private String name;
    public StaffCreateAccount(String name, String username, String password, String confirmPassword) {
        super(username, password, confirmPassword);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
