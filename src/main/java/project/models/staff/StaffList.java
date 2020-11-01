package project.models.staff;

import project.models.CheckLogin;

import java.util.ArrayList;

public class StaffList extends CheckLogin {
    private ArrayList<StaffCreateAccount> staffs;

    public StaffList() {
        staffs = new ArrayList<>();
    }
    public boolean checkUsernameStaff(String username) {
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkHaveUsernameAndPassword(String username, String password) {
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername())&&password.equals(staff.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkUsernameStaffWhenLogin(String username) {
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername()) && staff.getWithhold().equals("allow")) {
                return true;
            }
        }
        return false;
    }
    public String getNameStaff(String username) {
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername()) && staff.getWithhold().equals("allow")) {
                return staff.getName();
            }
        }
        throw new IllegalArgumentException();
    }
    public void setTimeStaff(String username, String time){
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername())){
                staff.setTime(time);
            }
        }
    }
    public boolean checkHaveNameStaff(String name) {
        for (StaffCreateAccount staff : staffs) {
            if (name.toLowerCase().contains(staff.getName().toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public void setWithholdStaff(StaffCreateAccount staff) {
        if (staff.getWithhold().equals("allow")) {
            staff.setWithhold("block");
        }
        else if (staff.getWithhold().equals("block")) {
            staff.setWithhold("allow");
        }
    }
    public void setPassword(String username, String password, String confirmPassword) {
        for (StaffCreateAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                staff.setPassword(password, confirmPassword);
            }
        }
    }
    public void addStaff(StaffCreateAccount staff){
        staffs.add(staff);
    }
    public ArrayList<StaffCreateAccount> getStaffs() {
        return staffs;
    }
}
