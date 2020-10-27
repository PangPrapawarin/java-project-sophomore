package sample.models.admin;

import sample.models.staff.StaffCreateAccount;

import java.util.ArrayList;

public class AdminList {
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
}
