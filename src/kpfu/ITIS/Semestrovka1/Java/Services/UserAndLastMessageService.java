package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.UserAndMessageDao;
import kpfu.ITIS.Semestrovka1.Java.Helper.UserAndLastMessage;
import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAndLastMessageService extends modelService {
    UserAndMessageDao userAndLastMessageDao;

    public UserAndLastMessageService() {
        this.userAndLastMessageDao = new UserAndMessageDao(getConnection());
    }

    public List<UserAndLastMessage> getLastMessageByUsers(List<User> users) {
        List<UserAndLastMessage> ans = new ArrayList<>();
        for (User user :
                users) {
            Message lastMessage = userAndLastMessageDao.findLastMessageByUserId(user.getId());
            if (lastMessage != null) {
                ans.add(new UserAndLastMessage(user, lastMessage));
            } else {
                ans.add(new UserAndLastMessage(user, null));
            }
        }
        return ans;
    }

    public void close() {
        userAndLastMessageDao.close();
    }
}
