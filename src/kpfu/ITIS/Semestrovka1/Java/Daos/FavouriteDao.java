package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Favourite;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavouriteDao implements CrudDao<Favourite> {
    Connection connection;

    public FavouriteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {

    }

    @Override
    public Favourite find(String by, String eql) {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(Favourite model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO favourites (author_id,recipe_id) VALUES (?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, model.getAuthorId());
            statement.setInt(2, model.getRecipeId());
            DaoHelper<User> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            //пока будет рандом
            daoHelper.checkingСhanges(statement);
        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
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

    public List<Integer> findAllFavoriteIdRecipes(int userId) {
        List<Integer> ans = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "Select favourites.recipe_id from favourites where author_id = ?"
        )) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ans.add(rs.getInt("recipe_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
