package hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Food;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface FoodMenuScreen {
    void showFoodMenu(List<Food> foodList);

    void navigateToAllergeneList();

    void navigateToFoodDetails(int id);
}
