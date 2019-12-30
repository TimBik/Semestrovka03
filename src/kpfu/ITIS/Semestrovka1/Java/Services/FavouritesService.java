package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Daos.FavouriteDao;
import kpfu.ITIS.Semestrovka1.Java.model.Favourite;
import kpfu.ITIS.Semestrovka1.Java.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FavouritesService extends modelService {
    FavouriteDao favouriteDao;

    public FavouritesService() {
        favouriteDao = new FavouriteDao(getConnection());
    }

    public void save(Favourite favourite) {
        favouriteDao.save(favourite);
    }

    public void close() {
        favouriteDao.close();
    }

    public List<Recipe> findAllFavoriteRecipes(int userId) {
        List<Recipe> ans = new ArrayList<>();
        RecipeService rs = new RecipeService();
        List<Integer> idRecipes = favouriteDao.findAllFavoriteIdRecipes(userId);
        for (int id :
                idRecipes) {
            ans.add(rs.findById(id));
        }
        return ans;
    }
}
