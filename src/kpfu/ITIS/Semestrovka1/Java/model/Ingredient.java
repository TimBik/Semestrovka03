package kpfu.ITIS.Semestrovka1.Java.model;

public class Ingredient implements HavingId{
    int id;
    int recipeId;
    String name;
    String amount;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String neme) {
        this.name = neme;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Ingredient(int id, int recipeId, String neme, String amount) {
        this.id = id;
        this.recipeId = recipeId;
        this.name = neme;
        this.amount = amount;
    }
}
