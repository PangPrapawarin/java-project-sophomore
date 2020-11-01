package project.models.guest;

import project.models.CreateAccounts;

public class GuestCreateAccount extends CreateAccounts {
    private String name;

    public GuestCreateAccount(String name, String username, String password, String confirmPassword) {
        super(username,password,confirmPassword);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
