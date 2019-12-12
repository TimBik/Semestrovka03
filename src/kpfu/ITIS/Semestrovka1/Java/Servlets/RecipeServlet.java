package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.CookieChecker;
import kpfu.ITIS.Semestrovka1.Java.Helper.Parser;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.IngredientService;
import kpfu.ITIS.Semestrovka1.Java.Services.RecipeService;
import kpfu.ITIS.Semestrovka1.Java.Services.StepService;
import kpfu.ITIS.Semestrovka1.Java.Services.UserService;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.Step;
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
import java.util.List;
import java.util.Map;

@WebServlet("/recipe/*")
public class RecipeServlet extends HttpServlet {
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
            int recipeId = new Parser().parse(req.getPathInfo());
            RecipeService rs = new RecipeService();
            Recipe recipe = rs.getRecipeById(recipeId);
            rs.close();
            StepService ss = new StepService();
            List<Step> steps = ss.getAllStepsByRecipeId(recipeId);
            ss.close();
            IngredientService is = new IngredientService();
            List<Ingredient> ingredients = is.getAllIngredientByRecipeId(recipeId);
            is.close();
            Map<String, Object> root = new HashMap<>();
            root.put("steps", steps);
            root.put("ingredients", ingredients);
            root.put("recipe", recipe);
            root.put("id", user.getId());
            resp.setContentType("text/html");
            Helper.render(req, resp, "recipe.ftl", root);
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
        super.doPost(req, resp);
    }
}
