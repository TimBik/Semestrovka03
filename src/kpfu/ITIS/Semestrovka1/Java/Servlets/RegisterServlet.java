package kpfu.ITIS.Semestrovka1.Java.Servlets;

import kpfu.ITIS.Semestrovka1.Java.Daos.UserDao;
import kpfu.ITIS.Semestrovka1.Java.Services.Args;
import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.User;
import org.omg.CORBA.Request;

import javax.servlet.RequestDispatcher;
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
import org.postgresql.Driver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
        HttpSession session = req.getSession();
        if (session.getAttribute("user_curent") == null) {
            resp.setContentType("text/html");
            RequestDispatcher dispatcher = req.getRequestDispatcher("ftl/register.ftl");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            doGet(req, resp);
        }
    }

    private Date createDateSql(String date) {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yy");
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
