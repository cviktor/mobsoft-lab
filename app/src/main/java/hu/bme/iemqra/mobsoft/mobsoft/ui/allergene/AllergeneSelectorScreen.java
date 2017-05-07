package hu.bme.iemqra.mobsoft.mobsoft.ui.allergene;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface AllergeneSelectorScreen {
    void showAllergens(List<Allergene> allergeneList);

    void navigateToFoodMenu();
}
