package project.models;

import java.util.ArrayList;

public class StaffAccount extends AdminAccount {
    private String time;
    private String name;
    private String withhold;
    private ArrayList<StaffAccount> staffs;

    public StaffAccount(String name, String username, String password, String confirmPassword, String withhold, String time) {
        super(username, password, confirmPassword);
        this.name = name;
        this.withhold = withhold;
        this.time = time;
    }
    public StaffAccount() {
        staffs = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return super.getUsername();
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
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
    public String getWithhold() {
        return withhold;
    }
    public void setWithhold(String withhold) {
        this.withhold = withhold;
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
    @Override
    public void setPassword(String username, String password, String confirmPassword) {
        for (StaffAccount staff : staffs) {
            if (username.equals(staff.getUsername())) {
                staff.setNewPassword(password, confirmPassword);
            }
        }
    }
}