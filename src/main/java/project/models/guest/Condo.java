package project.models.guest;

public class Condo extends GuestInfoList{
    //คอนโดมี 5 ตึก แต่ละตึกจะมี 9 ชั้นและแต่ละชั้นจะมี 10 ห้อง เลขห้องจะมาจาก เลขตึก+เลขชั้น+เลขที่ห้อง ฉะนั้นจะมี 4 หลัก ex. 2910
    public boolean checkBuildingNumber(int building) {
        if (building<=5 && building>0){
            return true;
        }
        return false;
    }
    public boolean checkFloorNumber(int floor){
        if (floor<=9 && floor>0) {
            return true;
        }
        return false;
    }
    public boolean checkRoomCondo(String building, String floor, String room) {
        String buildingNumber = room.substring(0,1);
        String floorNumber = room.substring(1,2);
        String roomNumber = room.substring(2);
        int roomNum = Integer.parseInt(roomNumber);
        int buildingNum = Integer.parseInt(buildingNumber);
        int floorNum = Integer.parseInt(floorNumber);
        if (roomNum<=10 && roomNum > 0) {
            if (buildingNum==Integer.parseInt(building)&&floorNum==Integer.parseInt(floor)&&room.equals(building+floor+roomNumber)){
                return true;
            }
        }
        return false;
    }
    public boolean checkRoomTypeGuest(String room, String people) {
        int i = Integer.parseInt(people);
        if (room.equals("1 ห้องนอน 1 ห้องน้ำ")) {
            if (i>0 && i<=2) {
                return true;
            }
            return false;
        }
        else if (room.equals("2 ห้องนอน 1 ห้องน้ำ")) {
            if (i>0 && i<=3) {
                return true;
            }
            return false;
        }
        else if (room.equals("2 ห้องนอน 2 ห้องน้ำ")) {
            if (i>0 && i<=4) {
                return true;
            }
            return false;
        }
        return false;
    }
}
