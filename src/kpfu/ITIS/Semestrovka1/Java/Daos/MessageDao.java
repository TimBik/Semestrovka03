package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageDao implements CrudDao<Message> {
    Connection connection;

    public MessageDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create() {

    }

    @Override
    public Message find(String by, String eql) {
        return null;
    }

    public List<Message> findAllMessageByUserFromId(int userFromId) {
        List<Message> messages = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM message WHERE from_user_id=?",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, userFromId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message message = createMessage(rs);
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    private Message createMessage(ResultSet rs) {
        Message message = null;
        try {
            message = new Message(
                    rs.getInt("id"),
                    rs.getInt("from_user_id"),
                    rs.getInt("to_user_id"),
                    rs.getString("text"),
                    rs.getTimestamp("date").toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(Message model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO message(id, from_user_id, to_user_id, text, date) VALUES (?,?,?,?,?)"
        )) {
            statement.setInt(1, model.getId());
            statement.setInt(2, model.getFromUserId());
            statement.setInt(3, model.getToUserId());
            statement.setString(4, model.getText());
            statement.setObject(5, model.getDate());
            DaoHelper<User> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            //пока будет рандом
            daoHelper.checkingСhanges(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Message> getAllMessageByUserId(int toUser, int fromUser) {
        List<Message> messages = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM message WHERE from_user_id=? AND to_user_id=?",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, toUser);
            ps.setLong(2, fromUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message message = createMessage(rs);
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }


}
