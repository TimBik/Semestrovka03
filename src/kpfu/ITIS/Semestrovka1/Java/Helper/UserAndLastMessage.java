package kpfu.ITIS.Semestrovka1.Java.Helper;

import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.User;

public class UserAndLastMessage {
    User user;
    Message message;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public UserAndLastMessage(User user, Message message) {
        this.user = user;
        this.message = message;
    }
}
