package project.models;

import java.util.ArrayList;

public class AdminAccount {
    private String username;
    private String password;
    private String confirmPassword;
    private ArrayList<AdminAccount> admins;

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
    public AdminAccount() {
        admins = new ArrayList<>();
    }
    public void addAccount(Object object){
        AdminAccount admin = (AdminAccount) object;
        admins.add(admin);
    }
    public void setPassword(String username, String password, String confirmPassword) {
        for (AdminAccount admin : admins) {
            if (username.equals(admin.getUsername())) {
                admin.setNewPassword(password, confirmPassword);
            }
        }
    }
    public boolean checkAccount(String username, String password) {
        for (AdminAccount admin : admins) {
            if (username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
                return true;
            }
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

    public ArrayList<AdminAccount> getAdmins() {
        return admins;
    }
}
