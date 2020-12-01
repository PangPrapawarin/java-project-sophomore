package project.models;

import java.util.ArrayList;

public class GuestList extends AdminList{
    private ArrayList<GuestAccount> guests;

    public GuestList() {
        guests = new ArrayList<>();
    }
    public boolean checkUsername(String username) {
        for (GuestAccount guest : guests) {
            if (username.equals(guest.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<GuestAccount> getGuests() {
        return guests;
    }
    public String getName(String username) {
        for (GuestAccount guest : guests) {
            if (username.equals(guest.getUsername())) {
                return guest.getName();
            }
        }
        return null;
    }
    @Override
    public boolean checkAccount(String username, String password) {
        for (GuestAccount guest : guests) {
            if (username.equals(guest.getUsername())&&password.equals(guest.getPassword())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void setPassword(String username, String password, String confirmPassword) {
        for (GuestAccount guest : guests) {
            if (username.equals(guest.getUsername())) {
                guest.setNewPassword(password, confirmPassword);
            }
        }
    }
    @Override
    public void addAccount(Object object){
        GuestAccount guest = (GuestAccount)object;
        guests.add(guest);
    }
}
