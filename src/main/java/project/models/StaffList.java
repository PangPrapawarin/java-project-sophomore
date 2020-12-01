package project.models;

import java.util.ArrayList;

public class StaffList extends AdminList{
    private ArrayList<StaffAccount> staffs;

    public StaffList() {
        staffs = new ArrayList<>();
    }
    @Override
    public boolean checkAccount(String username, String password) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername())&&password.equals(staff.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUsername(String username) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkUsernameStaffWhenLogin(String username) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername()) && staff.getWithhold().equals("allow")) {
                return true;
            }
        }
        return false;
    }
    public boolean checkHaveNameStaff(String name) {
        for (StaffAccount staff : staffs) {
            if (name.toLowerCase().contains(staff.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void setPassword(String username, String password, String confirmPassword) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                staff.setNewPassword(password, confirmPassword);
            }
        }
    }
    @Override
    public void addAccount(Object object){
        StaffAccount staff = (StaffAccount) object;
        staffs.add(staff);
    }
    public void setTimeStaff(String username, String time) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                staff.setTime(time);
            }
        }
    }
    public ArrayList<StaffAccount> getStaffs() {
        return staffs;
    }
    public String getName(String username) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername()) && staff.getWithhold().equals("allow")) {
                return staff.getName();
            }
        }
        return null;
    }
    public void setWithholdStaff(StaffAccount staff) {
        if (staff.getWithhold().equals("allow")) {
            staff.setWithhold("block");
        } else if (staff.getWithhold().equals("block")) {
            staff.setWithhold("allow");
        }
    }
}
