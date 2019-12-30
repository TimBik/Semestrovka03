package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredientDao implements CrudDao<Ingredient> {
    Connection connection;

    public IngredientDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {

    }

    @Override
    public Ingredient find(String by, String eql) {
        Ingredient ingredient = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipe" + by)) {
            statement.setString(1, eql);
            ResultSet resultSet = statement.executeQuery();
            //Если соответстующая строка найдена,обрабатываем её c помощью userRowMapper.
            //Соответствунно получаем объект User.
            if (resultSet.next()) {
                ingredient = createIngredient(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredient;
    }

    private Ingredient createIngredient(ResultSet rs) {
        Ingredient ingredient = null;
        try {
            ingredient = new Ingredient(
                    rs.getInt("id"),
                    rs.getInt("recipe_id"),
                    rs.getString("name"),
                    rs.getString("amount"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredient;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(Ingredient model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO ingredient (name,amount,recipe_id,id) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getName());
            statement.setString(2, model.getAmount());
            statement.setInt(3, model.getRecipeId());
            statement.setInt(4,model.getId());
            DaoHelper<User> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            //пока будет рандом
            daoHelper.checkingСhanges(statement);


        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            e.printStackTrace();
        }
    }

    public List<Ingredient> findAllIngredientByRecipeId(int id) {
        List<Ingredient> ingredients = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM ingredient WHERE recipe_id=?",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingredients.add(createIngredient(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }


    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
