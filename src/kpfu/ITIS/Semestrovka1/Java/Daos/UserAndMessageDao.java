package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Message;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;

import java.sql.*;

public class UserAndMessageDao {
    Connection connection;

    public UserAndMessageDao(Connection connection) {
        this.connection = connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Message findLastMessageByUserId(int UserId) {
        Message message = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT userandlastmessage.message FROM userandlastmessage where user_id=?")) {
            statement.setInt(1, UserId);
            ResultSet resultSet = statement.executeQuery();
            //Если соответстующая строка найдена,обрабатываем её c помощью userRowMapper.
            //Соответствунно получаем объект User.
            if (resultSet.next()) {
                try (PreparedStatement ss = connection.prepareStatement("SELECT * FROM message where id=" + resultSet.getInt("message"))) {
                    ResultSet rs = ss.executeQuery();
                    if (rs.next()) {
                        message = createMessage(rs);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    private Message createMessage(ResultSet rs) {
        Message message = null;
        try {
            message = new Message(
                    rs.getInt("id"),
                    rs.getInt("from_user_id"),
                    rs.getInt("to"),
                    rs.getString("text"),
                    rs.getTimestamp("date").toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

}
