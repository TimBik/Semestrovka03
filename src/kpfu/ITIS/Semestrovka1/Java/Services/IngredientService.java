package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.IngredientDao;
import kpfu.ITIS.Semestrovka1.Java.Daos.RecipeDao;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredientService extends modelService{
    IngredientDao ingredientDao;

    public IngredientService() {
        this.ingredientDao = new IngredientDao(getConnection());
    }

    public Ingredient createIngredient(int recipeId,String name, String amount) {
        Random random = new Random();
        return new Ingredient(random.nextInt(),recipeId,name,amount);
    }

    public void save(Ingredient ingredient) {
        new IngredientDao(getConnection()).save(ingredient);
    }

    public List<Ingredient> getAllIngredientByRecipeId(int id) {
        return ingredientDao.findAllIngredientByRecipeId(id);
    }

}
