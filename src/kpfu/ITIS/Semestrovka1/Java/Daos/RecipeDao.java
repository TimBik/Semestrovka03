package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeDao implements CrudDao<Recipe> {
    Connection connection;

    RecipeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {

    }

    @Override
    public Recipe find(String by, String eal) {
        return null;
    }

    @Override
    public void update() {

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
                "INSERT INTO recipe (authorid, recipetext,ingredientid,imagesid) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);) {
            statement.setInt(1, model.getAutorId());
            statement.setString(2, model.getRecipeText());
            statement.setInt(3, model.getIngredientId());
            statement.setInt(4, model.getImageId());
            DaoHelper<Recipe> daoHelper = new DaoHelper<>();
            daoHelper.checkingСhanges(statement);
            daoHelper.setId(statement,model);
        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            throw new IllegalStateException(e);
        }
    }

    Optional<List<Recipe>> findAllRecipesByUser(User model) {
        List<Recipe> recipes = null;
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM recipe WHERE autorid=?",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, model.getRecipeId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                recipes.add(createRecipeByRS(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(recipes);
    }

    private Recipe createRecipeByRS(ResultSet rs) {
        try {
            return new Recipe(rs.getInt("id"),
                    rs.getInt("authorid"),
                    rs.getString("recipetext"),
                    rs.getInt("ingredientid"),
                    rs.getInt("imageid"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
