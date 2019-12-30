package kpfu.ITIS.Semestrovka1.Java.Helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieChecker {
    public String getUserEmail(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        String userNameCookies = "userEmail";
        for (Cookie cookie :
                cookies) {
            if (cookie.equals(userNameCookies)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
