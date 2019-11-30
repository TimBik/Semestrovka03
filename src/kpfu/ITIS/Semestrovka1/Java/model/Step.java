package kpfu.ITIS.Semestrovka1.Java.model;

public class Step {
    int id;
    int idRecipe;
    String imageUrl;
    String text;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public Step(int id, int idRecipe, String imageUrl, String text) {
        this.id = id;
        this.idRecipe = idRecipe;
        this.imageUrl = imageUrl;
        this.text = text;
    }
}
