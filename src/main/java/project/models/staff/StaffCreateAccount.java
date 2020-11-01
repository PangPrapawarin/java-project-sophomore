package project.models.staff;

import project.models.CreateAccounts;

public class StaffCreateAccount extends CreateAccounts {
    private String time;
    private String name;
    private String withhold;

    public StaffCreateAccount(String name, String username, String password, String confirmPassword, String withhold, String time) {
        super(username, password, confirmPassword);
        this.name = name;
        this.withhold = withhold;
        this.time = time;
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
    public String getWithhold() {
        return withhold;
    }
    public void setWithhold(String withhold) {
        this.withhold = withhold;
    }
}
