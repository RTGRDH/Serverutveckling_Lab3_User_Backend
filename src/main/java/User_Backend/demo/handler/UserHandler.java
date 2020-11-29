package User_Backend.demo.handler;

import User_Backend.demo.bo.User;
import User_Backend.demo.bo.UsersEntity;

public class UserHandler {

    public static Boolean login(String user, String pass) {
        if(User.login(user, pass)){
            //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            //session.setAttribute("currentUser", user);
            return true;
        }
        return false;
    }
    public static boolean createUser(String userN, String passW){
        User.createUser(userN, passW);
        return true;
    }

    public static UsersEntity getUser(String name) {
        return User.getUser(name);
    }
}
