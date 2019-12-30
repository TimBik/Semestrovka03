package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.util.ArrayList;
import java.util.List;

public class FindUsersService extends FindService {
    public List<User> findAllUsers(String name) {
        UserService rs = new UserService();
        List<User> allUsers = rs.findAllUsers();
        rs.close();
        List<User> ans = new ArrayList<>();
        for (User user :
                allUsers) {
            if (cheak(user.getLogin(), name)) {
                ans.add(user);
            }
        }
        return ans;
    }

    private boolean cheak(String nameUser, String needFind) {
        return prefixFunction(needFind + "#" + nameUser, needFind.length());

    }
}
