package kpfu.ITIS.Semestrovka1.Java.model;

public class Recipe implements HavingId{
    int id;
    int autorId;
    String recipeText;
    int ingredientId;
    int imageId;

    public Recipe(int id, int autorId, String recipeText, int ingredientId, int imageId) {
        this.id = id;
        this.autorId = autorId;
        this.recipeText = recipeText;
        this.ingredientId = ingredientId;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
