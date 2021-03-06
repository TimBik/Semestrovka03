package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.AllRecipesAndItsThingsByRecipes;
import kpfu.ITIS.Semestrovka1.Java.Helper.RecipesAndItsIngredientsAndSteps;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.FindRecipesService;
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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
        cfg.setServletContextForTemplateLoading(this.getServletContext(), "/ftl");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        getServletContext().setAttribute("cfg", cfg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user != null) {
            Map<String, Object> root = new HashMap<>();
            if (req.getParameter("finder") != null) {
                String finder = req.getParameter("finder");
                root.put("recipesAndItsIngredientsAndSteps",
                        AllRecipesAndItsThingsByRecipes.recipesAndItsIngredientsAndSteps(
                                new FindRecipesService().findAllRecipes(finder)));
                root.put("userId",user.getId());
            }
            resp.setContentType("text/html");
            Helper.render(req, resp, "main.ftl", root);

        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            super.doPost(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
