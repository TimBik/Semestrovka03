package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserDao implements CrudDao<User> {
    Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {
    }

    @Override
    public User find(String by, String eql) {
        User user = null;
        ResultSet rs = DaoHelper.find(connection, "myuser", by, eql);
        if (rs != null) {
            user = createUser(rs);
        }
        return user;
    }

    public Optional<User> findUserByLogin(String login) {
        return Optional.ofNullable(find("login", " WHERE " + login + " = ?"));
    }


    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(find("email", " WHERE " + email + " = ?"));
    }

    private User createUser(ResultSet rs) {
        User user = null;
        try {
            user = new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getInt("tasteRaiting"),
                    rs.getString("email"),
                    rs.getDate("age"),
                    rs.getString("info"),
                    rs.getInt("recipeId"),
                    rs.getInt("messageId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Optional<List<User>> findAll() {
        List<User> users = null;
        ResultSet rs = DaoHelper.find(connection, "myuser", "", "");
        try {
            while (rs.next()) {
                users.add(createUser(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(users);
    }

    @Override
    public void update() {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(User model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO myuser (login, password,tasteraiting,email,age,info,recipeid,messageid,id) VALUES (?,?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setInt(3, model.getTasteRaiting());
            statement.setString(4, model.getEmail());
            statement.setDate(5, model.getAge());
            statement.setString(6, model.getInfo());
            statement.setInt(7, model.getRecipeId());
            statement.setInt(8, model.getMessageId());
            DaoHelper<User> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            //пока будет рандом
            statement.setInt(9, (new Random()).nextInt() * (int) 1e5);
            daoHelper.checkingСhanges(statement);


        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            e.printStackTrace();
        }
    }

}
