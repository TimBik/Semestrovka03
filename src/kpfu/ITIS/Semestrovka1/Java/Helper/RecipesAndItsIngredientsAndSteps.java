package kpfu.ITIS.Semestrovka1.Java.Helper;

import kpfu.ITIS.Semestrovka1.Java.Services.IngredientService;
import kpfu.ITIS.Semestrovka1.Java.Services.StepService;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.Step;

import java.util.ArrayList;
import java.util.List;

public class RecipesAndItsIngredientsAndSteps {
    Recipe recipe;
    List<Ingredient> ingredients;
    List<Step> steps;
    int ingredientsSize = 0;
    int stepsSize = 0;



    public Recipe getRecipe() {
        return recipe;
    }

    public int getIngredientsSize() {
        return ingredientsSize;
    }

    public int getStepsSize() {
        return stepsSize;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public RecipesAndItsIngredientsAndSteps(Recipe recipe, List<Ingredient> ingredients, List<Step> steps) {
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.steps = steps;
        this.ingredientsSize = ingredients.size();
        this.stepsSize = steps.size();
    }
}