package project.models.admin;

import project.models.CheckLogin;

import java.util.ArrayList;

public class AdminList extends CheckLogin {
    private ArrayList<AdminCreateAccount> admins;

    public AdminList() {
        admins = new ArrayList<>();
    }
    public void addAdmin(AdminCreateAccount admin){
        admins.add(admin);
    }

    public ArrayList<AdminCreateAccount> getAdmins() {
        return admins;
    }
    public boolean checkAdminAccount(String username, String password) {
        for (AdminCreateAccount admin : admins) {
            if (username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public void setPassword(String username, String password, String confirmPassword) {
        for (AdminCreateAccount admin : admins) {
            if (username.equals(admin.getUsername())) {
                admin.setPassword(password, confirmPassword);
            }
        }
    }
}
