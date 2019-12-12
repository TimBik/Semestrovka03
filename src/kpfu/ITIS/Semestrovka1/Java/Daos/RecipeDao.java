package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RecipeDao implements CrudDao<Recipe> {
    Connection connection;

    public RecipeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {

    }

    @Override
    public Recipe find(String by, String eql) {
        Recipe recipe = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipe" + by)) {
            statement.setInt(1, Integer.parseInt(eql));
            ResultSet resultSet = statement.executeQuery();
            //Если соответстующая строка найдена,обрабатываем её c помощью userRowMapper.
            //Соответствунно получаем объект User.
            if (resultSet.next()) {
                recipe = createRecipe(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    private Recipe createRecipe(ResultSet rs) {
        Recipe recipe = null;
        try {
            recipe = new Recipe(
                    rs.getInt("id"),
                    rs.getInt("author_id"),
                    rs.getString("photo"),
                    rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipe;
    }

    @Override
    public void update() {

    }

    public void updateRecipe(Recipe recipe) {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(Recipe model) {
        //Создаём новый объект PreparedStatement,с соотвествующим запросом для сохранния пользователя
        //Использование try-with-resources необходимо для гарантированного закрытия statement,вне зависимости от успешности операции.
        //Аргумент Statement.RETURN_GENERATED_KEYS даёт возможность хранения сгенерированных id (ключей)  внутри statement.
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO recipe (id,author_id,photo,name) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);) {
            statement.setInt(1, model.getId());
            statement.setInt(2, model.getAutorId());
            statement.setString(3, model.getPhoto());
            statement.setString(4, model.getName());
            DaoHelper<Recipe> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            daoHelper.checkingСhanges(statement);
        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            throw new IllegalStateException(e);
        }
    }


    public Optional<List<Recipe>> findAllRecipeByUserRecipeId(int recipeId) {
        List<Recipe> recipes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM recipe WHERE author_id=?",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, recipeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recipe recipe = createRecipe(rs);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(recipes);
    }

    public List<Recipe> findAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM recipe",
                Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Recipe recipe = createRecipe(rs);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Recipe findById(int id) {
        return find(" Where id=?", id + "");
    }
}
