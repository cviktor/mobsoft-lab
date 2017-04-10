package hu.bme.iemqra.mobsoft.mobsoft.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.AllergeneInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.FoodInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.UserInteractor;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Module
public class InteractorModule {
    @Provides
    public AllergeneInteractor provideAllergenes() {
        return new AllergeneInteractor();
    }

    @Provides
    public FoodInteractor provideFood() {
        return new FoodInteractor();
    }

    @Provides
    public UserInteractor provideUser() {
        return new UserInteractor();
    }
}
