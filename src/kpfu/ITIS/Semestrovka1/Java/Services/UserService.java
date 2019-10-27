package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.UserDao;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserService extends modelService<User>{
    UserDao userDao;

    public UserService() {
        this.userDao = new UserDao(getConnection());
    }

    public User getUserByLogin(String login){
        return userDao.findUserByLogin(login).orElse(null);
    }

    public void saveInBd(User user) {
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        return userDao.findUserByEmail(email).orElse(null);
    }
}
