package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.StepDao;
import kpfu.ITIS.Semestrovka1.Java.model.Ingredient;
import kpfu.ITIS.Semestrovka1.Java.model.Step;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class StepService extends modelService {
    private StepDao stepDao;

    public StepService() {
        this.stepDao = new StepDao(getConnection());
    }

    public Step createStep(int id, String text, String photo) {
        return new Step(new Random().nextInt(), id, photo, text);
    }

    public void save(Step step) {
        new StepDao(getConnection()).save(step);
    }

    public List<Step> getAllStepsByRecipeId(int id) {
        List<Step> steps = stepDao.findAllStepsByRecipeId(id);
        for (Step step : steps) {
            step.setImageUrl(".." + step.getImageUrl().split("Semesrovka_war_exploded")[1]);
        }
        return steps;
    }

    public void close()  {
        stepDao.close();
    }
}
