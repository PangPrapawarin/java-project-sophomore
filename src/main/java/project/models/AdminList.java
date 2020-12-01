package project.models;

import java.util.ArrayList;

public class AdminList {
    private ArrayList<AdminAccount> admins;

    public AdminList() {
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
    public ArrayList<AdminAccount> getAdmins() {
        return admins;
    }
}
