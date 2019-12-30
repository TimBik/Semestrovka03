package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.AllRecipesAndItsThingsByRecipes;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.FavouritesService;
import kpfu.ITIS.Semestrovka1.Java.Services.FindRecipesService;
import kpfu.ITIS.Semestrovka1.Java.Services.RecipeService;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/favourite")
public class FavoriteServlet extends HttpServlet {
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
        if (user != null) {
            resp.setContentType("text/html");
            FavouritesService rs = new FavouritesService();
            Map<String, Object> root = new HashMap<>();
            root.put("recipesAndItsIngredientsAndSteps",
                    AllRecipesAndItsThingsByRecipes.recipesAndItsIngredientsAndSteps(
                           rs.findAllFavoriteRecipes(user.getId())));
            root.put("userId", user.getId());
            Helper.render(req, resp, "favourite.ftl", root);
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
