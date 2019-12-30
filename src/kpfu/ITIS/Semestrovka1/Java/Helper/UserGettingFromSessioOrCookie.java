package kpfu.ITIS.Semestrovka1.Java.Helper;

import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserGettingFromSessioOrCookie {
    public User getUser(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user_curent");
        if (user == null) {
            UserService us = new UserService();
            user = us.getUserByEmail(new CookieChecker().getUserEmail(req));
            us.close();
        }
        return user;
    }
}
