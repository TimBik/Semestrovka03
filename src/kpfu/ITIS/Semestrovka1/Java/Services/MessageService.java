package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.MessageDao;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserAndLastMessage;
import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.util.*;

public class MessageService extends modelService {
    MessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao(getConnection());
    }

    void saveMessage(Message message) {
        messageDao.save(message);
    }

    public void close() {
        messageDao.close();
    }

    public List<Message> getAllMessagesByUserid(int toUser, int fromUser) {
        return messageDao.getAllMessageByUserId(toUser, fromUser);
    }

    public void save(Message message) {
        messageDao.save(message);
    }

    public List<Message> getAllMessagesByTwoUsersIdWithSort(int fromUser, int toUser) {
        List<Message> ans;
        ans = getAllMessagesByUserid(toUser, fromUser);
        ans.addAll(getAllMessagesByUserid(fromUser, toUser));
        Collections.sort(ans, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
        return ans;
    }
}
