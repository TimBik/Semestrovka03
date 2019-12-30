package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.AllRecipesAndItsThingsByRecipes;
import kpfu.ITIS.Semestrovka1.Java.Helper.RecipesAndItsIngredientsAndSteps;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.RecipeService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

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
            root.put("name", user.getLogin());
            root.put("email", user.getEmail());
            root.put("age", user.getAge());
            root.put("info", user.getInfo());
            root.put("raiting", user.getTasteRaiting());
            root.put("userId",user.getId());
            RecipeService rs = new RecipeService();
            List<Recipe> recipes = rs.getAllRecipeByUserRecipeId(user.getId());
            rs.close();
            List<RecipesAndItsIngredientsAndSteps> recipesAndItsIngredientsAndSteps =
                    AllRecipesAndItsThingsByRecipes.recipesAndItsIngredientsAndSteps(recipes);
            root.put("recipesAndItsIngredientsAndSteps", recipesAndItsIngredientsAndSteps);


            resp.setContentType("text/html");
            Helper.render(req, resp, "profile.ftl", root);
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /*private List<List<Ingredient>> getAllIngredientByRecipes(List<Recipe> recipes) {
        List<List<Ingredient>> ans = null;
        IngredientService is = new IngredientService();
        for (Recipe recipe :
                recipes) {
            ans.add(is.getAllIngredientByRecipeId(recipe.getId()));
        }
        return ans;
    }*/

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
