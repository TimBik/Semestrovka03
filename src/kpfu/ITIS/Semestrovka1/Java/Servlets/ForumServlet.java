package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.Parser;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserAndLastMessage;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.*;
import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.User;
import sun.util.resources.LocaleData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@WebServlet("/forum")
public class ForumServlet extends HttpServlet {
    @Override
    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setServletContextForTemplateLoading(this.getServletContext(), "/ftl");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        getServletContext().setAttribute("cfg", cfg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user != null) {
            String toUser = req.getParameter("toUser");
            if (toUser != null) {
                String message = req.getParameter("message");
                if (message != null && message != "") {
                    MessageService ms = new MessageService();
                    ms.save(new Message(new Random().nextInt(), user.getId(), new Parser().parse(toUser), message, LocalDateTime.now()));
                    ms.close();
                }
            }
            Map<String, Object> root = new HashMap<>();
            order(req, root, user);
            resp.setContentType("text/html");
            Helper.render(req, resp, "forum.ftl", root);
//            order(req, root, user);
//            resp.setContentType("text/html");
//            Helper.render(req, resp, "forum.ftl", root);

        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user != null) {
            Map<String, Object> root = new HashMap<>();
            order(req, root, user);
            resp.setContentType("text/html");
            Helper.render(req, resp, "forum.ftl", root);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }


    void order(HttpServletRequest req, Map<String, Object> root, User user) {
        String login = req.getParameter("search");
        List<UserAndLastMessage> usersAndLastMessages;
        if (login != null) {
            // MessageService ms = new MessageService();
            //List<Message> messages = ms.getAllMessagesByUserid(user.getId());
            FindUsersService fus = new FindUsersService();
            List<User> users = fus.findAllUsers(login);
            UserAndLastMessageService ualms = new UserAndLastMessageService();
            usersAndLastMessages = ualms.getLastMessageByUsers(users);
            ualms.close();
            //ms.close();
            //root.put("messages", messages);
            root.put("usersAndLastMessages1", usersAndLastMessages);
            root.put("login", login);
        }
        String toUser = req.getParameter("toUser");
        if (toUser != null) {
            MessageService ms = new MessageService();

            List<Message> messages = ms.getAllMessagesByTwoUsersIdWithSort(user.getId(), new Parser().parse(toUser));
            ms.close();
            root.put("messages", messages);
        }
        root.put("mainUser", user);
    }

}
