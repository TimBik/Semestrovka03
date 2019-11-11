package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.UserDao;
import kpfu.ITIS.Semestrovka1.Java.model.User;

public class UserService extends modelService<User> {
    UserDao userDao;

    public UserService() {
        this.userDao = new UserDao(getConnection());
    }

    public User getUserByLogin(String login) {
        return userDao.findUserByLogin(login).orElse(null);
    }

    public void saveInBd(User user) {
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        return userDao.findUserByEmail(email).orElse(null);
    }

    public void close() {
        userDao.close();
    }
}
