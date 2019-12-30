package kpfu.ITIS.Semestrovka1.Java.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import kpfu.ITIS.Semestrovka1.Java.Helper.Recode;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.IngredientService;
import kpfu.ITIS.Semestrovka1.Java.Services.RecipeService;
import kpfu.ITIS.Semestrovka1.Java.Services.StepService;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Step;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@WebServlet("/addRecipe")
@MultipartConfig
public class AddRecipeServlet extends HttpServlet {
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
            resp.setContentType("text/html");
            Helper.render(req, resp, "addRecipe.ftl", null);

        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user != null) {
            if (req.getParameter("saveNewRecipe") != null) {
                IngredientService is = new IngredientService();
                Random random = new Random();
                Recode r = new Recode();
                int id = random.nextInt();
                List<Ingredient> ingredients = new ArrayList<>();
                int k = 0;
                while (req.getParameter("nameIngredient" + k) != null) {
                    ingredients.add(is.createIngredient(id, r.recode(req.getParameter("nameIngredient" + k)), r.recode(req.getParameter("amountIngredient" + k))));
                    k++;
                }
                is.close();
                StepService ss = new StepService();
                List<Step> steps = new ArrayList<>();
                k = 0;
                while (req.getParameter("textStep" + k) != null) {
                    Part p = req.getPart("photoStep" + k);
                    steps.add(ss.createStep(id, r.recode(req.getParameter("textStep" + k)), createPhoto(p)));
                    k++;
                }
                ss.close();
                RecipeService rs = new RecipeService();
                Part p = req.getPart("photoRecipe");
                rs.saveInBd(rs.createRecipe(r.recode(req.getParameter("nameRecipe")), user.getId(), ingredients, steps, createPhoto(p)));
                rs.close();
            }
            try {
                resp.sendRedirect(req.getContextPath() + "/profile");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    String createPhoto(Part p) {
        String localdir = "uploads";
        String pathDir = getServletContext().getRealPath("") + localdir;
        File dir = new File(pathDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String[] filename_data = p.getSubmittedFileName().split("\\.");
        String filename = Math.random() + "." + filename_data[filename_data.length - 1];
        String fullpath = pathDir + File.separator + filename;
        try {
            p.write(fullpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullpath;
    }

}
