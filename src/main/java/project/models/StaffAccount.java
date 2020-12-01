package project.models;

import java.util.ArrayList;

public class StaffAccount extends AdminAccount {
    private String time;
    private String name;
    private String withhold;

    public StaffAccount(String name, String username, String password, String confirmPassword, String withhold, String time) {
        super(username, password, confirmPassword);
        this.name = name;
        this.withhold = withhold;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    @Override
    public String getUsername() {
        return super.getUsername();
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getWithhold() {
        return withhold;
    }
    public void setWithhold(String withhold) {
        this.withhold = withhold;
    }
}
