package kpfu.ITIS.Semestrovka1.Java.Services;

import com.sun.deploy.net.HttpRequest;
import kpfu.ITIS.Semestrovka1.Java.Daos.RecipeDao;
import kpfu.ITIS.Semestrovka1.Java.Daos.UserDao;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.Step;
import kpfu.ITIS.Semestrovka1.Java.model.User;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class RecipeService extends modelService<Recipe> {
    RecipeDao recipeDao;

    public RecipeService() {
        this.recipeDao = new RecipeDao(getConnection());
    }

    public List<Recipe> getAllRecipeByUserRecipeId(int userRecipeId) {
        return recipeDao.findAllRecipeByUserRecipeId(userRecipeId).orElse(null);
    }

    public void saveInBd(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public Recipe createRecipe(String name, int authorId, List<Ingredient> ingredients, List<Step> steps, String photo) {
        Random rand = new Random();
        Recipe recipe = new Recipe(Math.abs(rand.nextInt()), authorId, photo, name);
        StepService stepService = new StepService();
        for (Step step : steps) {
            step.setIdRecipe(recipe.getId());
            stepService.save(step);
        }
        IngredientService ingredientService = new IngredientService();
        for (Ingredient ingredient : ingredients) {
            ingredient.setRecipeId(recipe.getId());
            ingredientService.save(ingredient);
        }
        return recipe;
    }


    public void updateRecipe(Recipe recipe) {
        recipeDao.updateRecipe(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeDao.findAllRecipes();
    }

    public void close() {
        recipeDao.close();
    }

    public Recipe findById(int id) {
        return recipeDao.findById(id);
    }

    public Recipe getRecipeById(int recipeId) {
        return recipeDao.findById(recipeId);
    }

    public boolean haveRecipe(int recipeId) {
        return recipeDao.findById(recipeId) == null;
    }
}
