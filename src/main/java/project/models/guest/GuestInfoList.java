package project.models.guest;

import java.util.ArrayList;

public class GuestInfoList {
    private ArrayList<NewGuestInfo> guestInfoList;

    public GuestInfoList() {
        guestInfoList = new ArrayList<>();
    }
    public void addGuestInfo(NewGuestInfo guest) {
        guestInfoList.add(guest);
    }
    public boolean checkHaveNameGuest(String name) {
        for (NewGuestInfo nameInfo : guestInfoList) {
            if (name.contains(nameInfo.getName())) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<NewGuestInfo> getGuestInfoList() {
        return guestInfoList;
    }

    public ArrayList<NewGuestInfo> search(String name) {
        ArrayList<NewGuestInfo> newList = new ArrayList<>();
        for (NewGuestInfo realName: guestInfoList) {
            if (realName.getName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(realName);
            }
        }
        return newList;
    }
    public boolean checkHaveRoom(String room) {
        for (NewGuestInfo guest : guestInfoList) {
            if (room.equals(guest.getRoomNumber())) {
                return true;
            }
        }
        return false;
    }
}
