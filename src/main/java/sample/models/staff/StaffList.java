package sample.models.staff;

import sample.models.CreateAccounts;

import java.util.ArrayList;

public class StaffList {
    private ArrayList<StaffCreateAccount> staffs;

    public StaffList() {
        staffs = new ArrayList<>();
    }
    public void addStaff(StaffCreateAccount staff){
        staffs.add(staff);
    }
    public void removeStaff(StaffCreateAccount staff){
        staffs.remove(staff);
    }
    //    public CreateAccounts findByName(String name) {
//        for ( )
//    }
    public ArrayList<StaffCreateAccount> getStaffs() {
        return staffs;
    }
}
