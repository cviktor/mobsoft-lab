package hu.bme.iemqra.mobsoft.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.InteractorModule;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.AllergeneInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.FoodInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.UserInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.repository.RepositoryModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneSelectorActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneSelectorPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails.FoodDetailsActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails.FoodDetailsPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(FoodMenuActivity mainActivity);
    void inject(FoodDetailsActivity mainActivity);
    void inject(AllergeneSelectorActivity mainActivity);

    void inject(AllergeneInteractor allergeneInteractor);
    void inject(FoodInteractor foodInteractor);
    void inject(UserInteractor userInteractor);

    void inject(MainPresenter presenter);
    void inject(FoodMenuPresenter presenter);
    void inject(FoodDetailsPresenter presenter);
    void inject(AllergeneSelectorPresenter presenter);

}
