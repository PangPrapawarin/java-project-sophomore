package project.models;

import java.util.ArrayList;

public class GuestList extends AdminList{
//    private ArrayList<GuestAccount> guests;
//
//    public GuestList() {
//        guests = new ArrayList<>();
//    }
    public boolean checkUsername(String username) {
        for (AdminAccount guest : super.getAccountList()) {
            if (username.equals(guest.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public String getName(String username) {
        for (AdminAccount guest : super.getAccountList()) {
            if (username.equals(guest.getUsername())) {
                return guest.getName();
            }
        }
        return null;
    }
    @Override
    public boolean checkAccount(String username, String password) {
            if (super.checkAccount(username, password)) {
                checkUsername(username);
                return true;
            }
        return false;
    }
}
