package project.models;

public class CreateAccounts {
    private String username;
    private String password;
    private String confirmPassword;

    public CreateAccounts(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean setPassword(String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            this.password = password;
            this.confirmPassword = confirmPassword;
            return true;
        }
        return false;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
