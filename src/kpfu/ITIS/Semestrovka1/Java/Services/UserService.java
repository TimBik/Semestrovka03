package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.UserDao;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserAndLastMessage;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.util.List;

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
        if (email == null) return null;
        return userDao.findUserByEmail(email).orElse(null);
    }

    public void close() {
        userDao.close();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void addFavoriteRecipe(int userId, int recipeId) {
        userDao.addFavoriteRecipe(userId, recipeId);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

}
