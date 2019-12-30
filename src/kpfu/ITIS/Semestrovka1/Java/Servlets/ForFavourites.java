package kpfu.ITIS.Semestrovka1.Java.Servlets;

import kpfu.ITIS.Semestrovka1.Java.Helper.Parser;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserGettingFromSessioOrCookie;
import kpfu.ITIS.Semestrovka1.Java.Services.FavouritesService;
import kpfu.ITIS.Semestrovka1.Java.Services.RecipeService;
import kpfu.ITIS.Semestrovka1.Java.Services.StepService;
import kpfu.ITIS.Semestrovka1.Java.model.Favourite;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/forFavourites")
public class ForFavourites extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new UserGettingFromSessioOrCookie().getUser(req);
        if (user != null) {
            int userId = new Parser().parse(req.getParameter("UserId"));

            int recipeId = new Parser().parse(req.getParameter("RecipeId"));
            RecipeService rs = new RecipeService();
            if (!rs.haveRecipe(recipeId)) {
                FavouritesService fs = new FavouritesService();
                fs.save(new Favourite(userId, recipeId));
                fs.close();
            }
            rs.close();
        }
    }
}
