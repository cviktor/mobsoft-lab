package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneSelectorActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails.FoodDetailsActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(FoodMenuActivity mainActivity);
    void inject(FoodDetailsActivity mainActivity);
    void inject(AllergeneSelectorActivity mainActivity);
}
