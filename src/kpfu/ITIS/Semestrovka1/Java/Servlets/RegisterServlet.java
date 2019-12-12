package kpfu.ITIS.Semestrovka1.Java.Servlets;

import kpfu.ITIS.Semestrovka1.Java.Helper.CookieChecker;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setServletContextForTemplateLoading(this.getServletContext(), "/ftl");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        getServletContext().setAttribute("cfg", cfg);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user ==null) {
            resp.setContentType("text/html");
            Helper.render(req, resp, "register.ftl", null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user == null) {

            UserService userService = new UserService();
            User user1 = userService.getUserByLogin(req.getParameter("username"));
            User user2 = userService.getUserByEmail(req.getParameter("email"));
            if (user1 == null && user2 == null) {
                userService.saveInBd(new User(req.getParameter("username"),
                        req.getParameter("password"),
                        1,
                        req.getParameter("email"),
                        createDateSql(req.getParameter("birthDate")),
                        "",
                        (new Random()).nextInt() * (int) 1e5,
                        (new Random()).nextInt() * (int) 1e5));
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                Helper.render(req, resp, "register.ftl", null);
            }
            userService.close();
        }
    }

    private Date createDateSql(String date) {
        DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            //неправльная дата рождения
        }
        return new java.sql.Date(utilDate.getTime());
    }
}
