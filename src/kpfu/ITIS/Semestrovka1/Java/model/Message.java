package kpfu.ITIS.Semestrovka1.Java.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Message implements HavingId {
    int id;
    int fromUserId;
    int toUserId;
    String text;
    LocalDateTime date;

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

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }


    public Message() {
        this.id = 0;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Message(int id, int fromUserId, int toUserId, String text, LocalDateTime date) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.text = text;
        this.date = date;
    }
}
