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
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import org.postgresql.Driver;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        RequestDispatcher rd = req.getRequestDispatcher("Pages/register.html");
        rd.forward(req, resp);
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
