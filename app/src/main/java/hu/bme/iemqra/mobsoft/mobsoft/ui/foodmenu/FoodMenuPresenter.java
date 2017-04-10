package hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.FoodInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainScreen;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class FoodMenuPresenter extends Presenter<FoodMenuScreen> {

    @Inject
    FoodInteractor foodInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public FoodMenuPresenter() {
    }

    @Override
    public void attachScreen(FoodMenuScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getFoodList(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                foodInteractor.getFood();
            }
        });
    }

    public void onEventMainThread(GetFoodEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFoodMenu(new ArrayList<Food>());
            }
        } else {
            if (screen != null) {
                screen.showFoodMenu(event.getFoodList());
            }
        }
    }
}
