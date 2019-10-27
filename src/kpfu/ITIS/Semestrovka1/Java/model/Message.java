package kpfu.ITIS.Semestrovka1.Java.model;

public class Message implements HavingId{
    int id;
    int fromUserId;
    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(int id, int fromUserId, String text) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.text = text;
    }
}
