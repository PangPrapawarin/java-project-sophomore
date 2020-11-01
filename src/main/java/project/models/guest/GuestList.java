package project.models.guest;

import project.models.CheckLogin;

import java.util.ArrayList;

public class GuestList extends CheckLogin {
    private ArrayList<GuestCreateAccount> guestList;

    public GuestList() {
        guestList = new ArrayList<>();
    }
    public void addGuest(GuestCreateAccount guest) {
        guestList.add(guest);
    }
    public boolean checkUsernameGuest(String username) {
        for (GuestCreateAccount guest : guestList) {
            if (username.equals(guest.getUsername())) {
                return false;
            }
        }
        return true;
    }
    public boolean checkHaveUsernameAndPassword(String username, String password) {
        for (GuestCreateAccount guest : guestList) {
            if (username.equals(guest.getUsername())&&password.equals(guest.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkUsernameGuestWhenLogin(String username) {
        for (GuestCreateAccount guest : guestList) {
            if (username.equals(guest.getUsername())){
                return true;
            }
        }
        return false;
    }
    public String getNameGuest(String username) {
        for (GuestCreateAccount guest : guestList) {
            if (username.equals(guest.getUsername())) {
                return guest.getName();
            }
        }
        throw new IllegalArgumentException();
    }
    public void setPassword(String username, String password, String confirmPassword) {
        for (GuestCreateAccount guest : guestList) {
            if (username.equals(guest.getUsername())) {
                guest.setPassword(password, confirmPassword);
            }
        }
    }
    public ArrayList<GuestCreateAccount> getGuestList() {
        return guestList;
    }
}
