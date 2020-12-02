package project.models;

import java.util.ArrayList;

public class AdminList {
    private ArrayList<AdminAccount> admins;
    private AdminAccount adminAccount;

    public AdminList() {
        admins = new ArrayList<>();
    }
    public void addAccount(AdminAccount admin){
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

    public AdminAccount getAccount() {
        return adminAccount;
    }

    public ArrayList<AdminAccount> getAccountList() {
        return admins;
    }
}
