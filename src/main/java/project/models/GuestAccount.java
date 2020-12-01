package project.models;

import java.util.ArrayList;

public class GuestAccount extends AdminAccount {
    private String name;

    public GuestAccount(String name, String username, String password, String confirmPassword) {
        super(username,password,confirmPassword);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
