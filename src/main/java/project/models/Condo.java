package project.models;

import java.util.ArrayList;

public class Condo {
    private String roomNumber;
    private String floorNumber;
    private String buildingNumber;
    private String roomType;
    private String name;
    private String people;
    private ArrayList<Condo> guestInfoList;

    public Condo(String roomNumber, String floorNumber, String buildingNumber, String roomType, String name, String people) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.buildingNumber = buildingNumber;
        this.roomType = roomType;
        this.name = name;
        this.people = people;
    }
    public Condo(){
        guestInfoList = new ArrayList<>();
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getName() {
        return name;
    }

    public String getPeople() {
        return people;
    }

    public void addGuestInfo(Condo guestInfo){
        guestInfoList.add(guestInfo);
    }

    public ArrayList<Condo> search(String name) {
        ArrayList<Condo> newList = new ArrayList<>();
        for (Condo realName: guestInfoList) {
            if (realName.getName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(realName);
            }
        }
        return newList;
    }

    public ArrayList<Condo> getGuestInfoList() {
        return guestInfoList;
    }
    public boolean checkHaveNameGuest(String name) {
            for (Condo nameInfo : guestInfoList) {
                if (name.contains(nameInfo.getName())) {
                    return true;
                }
            }
        return false;
    }
    public boolean checkHaveRoom(String room) {
        for (Condo guest : guestInfoList) {
            if (room.equals(guest.getRoomNumber())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkBuildingNumber(int building) {
        if (building <= 5 && building > 0) {
            return true;
        }
        return false;
    }
    public boolean checkFloorNumber(int floor) {
        if (floor <= 9 && floor > 0) {
            return true;
        }
        return false;
    }
    public boolean checkRoomCondo(String building, String floor, String room) {
        String buildingNumber = room.substring(0, 1);
        String floorNumber = room.substring(1, 2);
        String roomNumber = room.substring(2);
        int roomNum = Integer.parseInt(roomNumber);
        int buildingNum = Integer.parseInt(buildingNumber);
        int floorNum = Integer.parseInt(floorNumber);
        if (roomNum <= 10 && roomNum > 0) {
            if (buildingNum == Integer.parseInt(building) && floorNum == Integer.parseInt(floor) && room.equals(building + floor + roomNumber)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkRoomTypeGuest(String room, String people) {
        int i = Integer.parseInt(people);
        if (room.equals("1 bedroom 1 bathroom")) {
            if (i > 0 && i <= 2) {
                return true;
            }
            return false;
        } else if (room.equals("2 bedroom 1 bathroom")) {
            if (i > 0 && i <= 3) {
                return true;
            }
            return false;
        } else if (room.equals("2 bedroom 2 bathroom")) {
            if (i > 0 && i <= 4) {
                return true;
            }
            return false;
        }
        return false;
    }
}
