package hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.FoodInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodDetailsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuScreen;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class FoodDetailsPresenter extends Presenter<FoodDetailsScreen> {
    @Inject
    FoodInteractor foodInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public FoodDetailsPresenter(){

    }

    @Override
    public void attachScreen(FoodDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getFoodDetails(final int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                foodInteractor.getFoodDetails(id);
            }
        });
    }

    public void updateFood(final Food food){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                foodInteractor.updateFood(food);
            }
        });
    }

    public void onEventMainThread(GetFoodDetailsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFoodDetails(null);
            }
        } else {
            if (screen != null) {
                screen.showFoodDetails(event.getFood());
            }
        }
    }
}
