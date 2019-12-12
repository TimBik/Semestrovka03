package kpfu.ITIS.Semestrovka1.Java.model;

import java.sql.Date;

public class User implements HavingId{
    int id;
    String login;
    String password;
    int tasteRaiting;
    String email;
    Date age;
    String info;
    int recipeId;
    int messageId;
    public User(){
        this.id = 0;
    }
    public User(int id, String login, String password, int tasteRaiting, String email, Date age, String info, int recipeId, int messageId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.tasteRaiting = tasteRaiting;
        this.email = email;
        this.age = age;
        this.info = info;
        this.recipeId = recipeId;
        this.messageId = messageId;
    }

    public User(String login, String password, int tasteRaiting, String email, Date age, String info, int recipeId, int messageId) {
        this.login = login;
        this.password = password;
        this.tasteRaiting = tasteRaiting;
        this.email = email;
        this.age = age;
        this.info = info;
        this.recipeId = recipeId;
        this.messageId = messageId;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTasteRaiting() {
        return tasteRaiting;
    }

    public void setTasteRaiting(int tasteRaiting) {
        this.tasteRaiting = tasteRaiting;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
