package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.RecipeDao;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindRecipesService extends FindService{

    public List<Recipe> findAllRecipes(String name) {
        RecipeService rs = new RecipeService();
        List<Recipe> allRecipes = rs.findAllRecipes();
        rs.close();
        List<Recipe> ans = new ArrayList<>();
        for (Recipe recipe :
                allRecipes) {
            if (cheak(recipe.getName(), name)) {
                ans.add(recipe);
            }
        }
        return ans;
    }

    private boolean cheak(String nameRecipe, String needFind) {
        return prefixFunction(needFind + "#" + nameRecipe, needFind.length());

    }



}
