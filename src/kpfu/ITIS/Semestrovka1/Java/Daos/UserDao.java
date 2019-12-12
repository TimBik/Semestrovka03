package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.ArrayList;
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
    public User find(String eql, String by) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM myuser" + by)) {
            statement.setString(1, eql);
            ResultSet resultSet = statement.executeQuery();
            //Если соответстующая строка найдена,обрабатываем её c помощью userRowMapper.
            //Соответствунно получаем объект User.
            if (resultSet.next()) {
                user = createUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Optional<User> findUserByLogin(String login) {
        return Optional.ofNullable(find(login, " WHERE login=?"));
    }


    public Optional<User> findUserByEmail(String email) {

        return Optional.ofNullable(find(email, " WHERE email=?"));

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

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM myuser")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users.add(createUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update() {

    }

    public void updateUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE myuser SET login = ?,info = ? WHERE id=?")) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getInfo());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addFavoriteRecipe(int userId, int recipeId) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users_recipes(id_user, id_recipe) VALUES(?,?)")) {
            statement.setInt(1, userId);
            statement.setInt(2, recipeId);
            DaoHelper<User> daoHelper = new DaoHelper<>();
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
}
