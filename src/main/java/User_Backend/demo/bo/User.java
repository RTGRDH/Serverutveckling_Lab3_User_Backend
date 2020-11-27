package User_Backend.demo.bo;

import User_Backend.demo.db.UserDB;

public class User {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    public static Boolean login(String user, String pass) { return UserDB.login(user, pass); }
    public static void createUser(String user, String pass) { UserDB.createUser(user, pass); }
}
