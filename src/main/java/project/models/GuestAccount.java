package project.models;

import java.util.ArrayList;

public class GuestAccount extends AdminAccount {
    private String name;
    private ArrayList<GuestAccount> guests;

    @Override
    public void addAccount(Object object){
        GuestAccount guest = (GuestAccount)object;
        guests.add(guest);
    }
    public GuestAccount(String name, String username, String password, String confirmPassword) {
        super(username,password,confirmPassword);
        this.name = name;
    }
    public GuestAccount() {
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
    public String getName(String username) {
        for (GuestAccount guest : guests) {
            if (username.equals(guest.getUsername())) {
                return guest.getName();
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public ArrayList<GuestAccount> getGuests() {
        return guests;
    }
}
