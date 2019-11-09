package kpfu.ITIS.Semestrovka1.Java.Servlets;

import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user_curent");
        if(user != null) {
            resp.setContentType("text/jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Pages/main.html");
            dispatcher.forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
