package project.models;

import java.util.ArrayList;

public class AdminAccount {
    private String username;
    private String password;
    private String confirmPassword;

    public AdminAccount(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public boolean setNewPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)){
            this.password = password;
            this.confirmPassword = confirmPassword;
            return true;
        }
        return false;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getWithhold() {
        return null;
    }

    public String getName() {
        return null;
    }

    public void setTime(String time) {
    }

    public String getTime() {
        return null;
    }
}
