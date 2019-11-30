package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.Recipe;
import kpfu.ITIS.Semestrovka1.Java.model.Step;
import kpfu.ITIS.Semestrovka1.Java.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StepDao implements CrudDao<Step> {
    Connection connection;

    public StepDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create() {

    }

    @Override
    public Step find(String by, String eql) {
        Step step = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM step" + by)) {
            statement.setString(1, eql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                step = createStep(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return step;
    }

    public List<Step> findAll(String by, String eql) {
        ArrayList<Step> steps = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM step" + by)) {
            statement.setString(1, eql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                steps.add(createStep(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return steps;
    }

    private Step createStep(ResultSet resultSet) {
        Step step = null;
        try {
            step = new Step(
                    resultSet.getInt("id"),
                    resultSet.getInt("idrecipe"),
                    resultSet.getString("photo"),
                    resultSet.getString("text"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return step;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleate() {

    }

    @Override
    public void save(Step model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO step (id, idrecipe,photo,text) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, model.getId());
            statement.setInt(2, model.getIdRecipe());
            statement.setString(3, model.getImageUrl());
            statement.setString(4, model.getText());
            DaoHelper<User> daoHelper = new DaoHelper<>();
            //daoHelper.setId(statement,model);
            //пока будет рандом
            daoHelper.checkingСhanges(statement);


        } catch (SQLException e) {
            //Если сохранений провалилось, обернём пойманное исключение в непроверяемое и пробросим дальше(best-practise)
            e.printStackTrace();
        }
    }

    public List<Step> findAllStepsByRecipeId(int id) {
        List<Step> steps = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM step WHERE idrecipe=?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                steps.add(createStep(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return steps;
    }
}
