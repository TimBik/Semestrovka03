package kpfu.ITIS.Semestrovka1.Java.model;

public class Recipe implements HavingId {
    int id;
    int autorId;
    String photo;
    String name;

    public Recipe(int id, int autorId, String photo, String name) {
        this.id = id;
        this.autorId = autorId;
        this.photo = photo;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
