package sample.models;

import java.util.ArrayList;

public class CheckLogin {
    private ArrayList<CreateAccounts> accounts;
    private CreateAccounts currentAccount;

    public CheckLogin(){
        accounts = new ArrayList<>();
    }
    public boolean checkUsername(String username){
        for (CreateAccounts acc : accounts){
            if (acc.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean checkPassword(String password){
        for (CreateAccounts acc : accounts){
            if (acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean checkLogin(String username, String password){
        for (CreateAccounts acc : accounts){
            if (checkUsername(username) && checkPassword(password)){
                return true;
            }
        }
        return false;
    }
}
