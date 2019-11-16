package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/profileSetings")
public class ProfileSetingsServlet extends HttpServlet {

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
        User user = (User) session.getAttribute("user_curent");
        if (user != null) {

            resp.setContentType("text/html");
            Helper.render(req, resp, "profileSetings.ftl", createRoot(user));

        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user_curent");
        if (user != null) {
            if (req.getParameter("saveSettings") != null) {
                user.setLogin(req.getParameter("username"));
                user.setInfo(req.getParameter("info"));
                saveSettings(user);
            }
            Helper.render(req, resp, "profile.ftl", createRoot(user));
        } else {

        }
    }

    public Map createRoot(User user) {
        Map<String, Object> root = new HashMap<>();
        root.put("name", user.getLogin());
        root.put("email", user.getEmail());
        root.put("age", user.getAge());
        root.put("info", user.getInfo());
        root.put("raiting", user.getTasteRaiting());
        return root;
    }

    public void saveSettings(User user) {
        new UserService().updateUser(user);
    }


}
