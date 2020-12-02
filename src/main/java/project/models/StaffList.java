package project.models;

import java.util.ArrayList;

public class StaffList extends AdminList{
    @Override
    public boolean checkAccount(String username, String password) {
            if (super.checkAccount(username, password)) {
                checkUsernameStaffWhenLogin(username);
                return true;
            }
        return false;
    }

    public boolean checkUsername(String username) {
        for (AdminAccount staff : super.getAccountList()) {
            if (username.equals(staff.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkUsernameStaffWhenLogin(String username) {
        for (AdminAccount staff : super.getAccountList()) {
            if (username.equals(staff.getUsername()) && staff.getWithhold().equals("allow")) {
                return true;
            }
        }
        return false;
    }
    public boolean checkHaveNameStaff(String name) {
        for (AdminAccount staff : super.getAccountList()) {
            if (name.toLowerCase().contains(staff.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void setTimeStaff(String username, String time) {
        for (AdminAccount staff : super.getAccountList()) {
            if (username.equals(staff.getUsername())) {
                staff.setTime(time);
            }
        }
    }
    public String getName(String username) {
        for (AdminAccount staff : super.getAccountList()) {
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
