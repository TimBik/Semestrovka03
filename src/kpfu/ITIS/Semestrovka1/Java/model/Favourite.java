package kpfu.ITIS.Semestrovka1.Java.model;

public class Favourite {
    int authorId;
    int recipeId;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public Favourite(int authorId, int recipeId) {
        this.authorId = authorId;
        this.recipeId = recipeId;
    }
}
