package kpfu.ITIS.Semestrovka1.Java.Helper;

import kpfu.ITIS.Semestrovka1.Java.Services.IngredientService;
import kpfu.ITIS.Semestrovka1.Java.Services.StepService;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class AllRecipesAndItsThingsByRecipes {
    static public List<RecipesAndItsIngredientsAndSteps> recipesAndItsIngredientsAndSteps(List<Recipe> recipes) {
        List<RecipesAndItsIngredientsAndSteps> recipesAndItsIngredientsAndSteps = new ArrayList<>();
        String name = "no name";
        IngredientService is = new IngredientService();
        StepService ss = new StepService();
        for (Recipe recipe : recipes) {
            if (recipe.getName() == null) {
                recipe.setName(name);
            }
            String[] asd = recipe.getPhoto().split("Semesrovka_war_exploded");
            recipe.setPhoto(".." + recipe.getPhoto().split("Semesrovka_war_exploded")[1]);
            recipesAndItsIngredientsAndSteps.add(new RecipesAndItsIngredientsAndSteps(
                    recipe,
                    is.getAllIngredientByRecipeId(recipe.getId()),
                    ss.getAllStepsByRecipeId(recipe.getId())));
        }
        is.close();
        ss.close();
        return recipesAndItsIngredientsAndSteps;
    }
}
