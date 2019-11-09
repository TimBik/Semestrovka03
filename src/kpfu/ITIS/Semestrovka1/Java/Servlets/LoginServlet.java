package kpfu.ITIS.Semestrovka1.Java.Servlets;

import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("Pages/login.html");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user_curent") == null) {
            UserService userService = new UserService();
            User user = userService.getUserByEmail(req.getParameter("email"));
            if (user != null && user.getPassword().equals(req.getParameter("password"))) {
                session.setAttribute("user_curent", user);
                resp.sendRedirect(req.getContextPath() + "/main");

            } else {
                doGet(req, resp);
            }
        }else {
            doGet(req, resp);
        }
    }
}
