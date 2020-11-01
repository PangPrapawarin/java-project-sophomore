package project.models.guest;

public class NewGuestInfo {
    private String roomNumber;
    private String floorNumber;
    private String buildingNumber;
    private String roomType;
    private String name;
    private String people;

    public NewGuestInfo(String roomNumber, String floorNumber, String buildingNumber, String roomType, String name, String people) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.buildingNumber = buildingNumber;
        this.roomType = roomType;
        this.name = name;
        this.people = people;
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

    public void setPeople(String people) {
        this.people = people;
    }
}
