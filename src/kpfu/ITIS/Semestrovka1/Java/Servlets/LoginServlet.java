package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.*;
import kpfu.ITIS.Semestrovka1.Java.Helper.CookieChecker;
import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setServletContextForTemplateLoading(this.getServletContext(), "/ftl");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        getServletContext().setAttribute("cfg", cfg);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (session.getAttribute("user_curent") == null) {
            resp.setContentType("text/html");
            Helper.render(req, resp, "login.ftl", null);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        if (session.getAttribute("user_curent") == null && new CookieChecker().getUserEmail(req)== null) {
            UserService userService = new UserService();
            User user = userService.getUserByEmail(req.getParameter("email"));
            userService.close();
            if (user != null && user.getPassword().equals(req.getParameter("password"))) {
                session.setAttribute("user_curent", user);
                if (req.getParameter("rememberMe") != null) {
                    Cookie cookie = new Cookie("userEmail", user.getEmail());
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookie);
                }
                try {
                    resp.sendRedirect(req.getContextPath() + "/main");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                doGet(req, resp);
            }
        } else {
            doGet(req, resp);
        }
    }
}
