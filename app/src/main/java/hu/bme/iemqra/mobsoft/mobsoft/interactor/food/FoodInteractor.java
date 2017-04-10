package hu.bme.iemqra.mobsoft.mobsoft.interactor.food;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodDetailsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.UpdateFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class FoodInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public FoodInteractor() {
       MobSoftApplication.injector.inject(this);
    }

    public void getFood(){
        GetFoodEvent event = new GetFoodEvent();

        //TODO server call

        bus.post(event);
    }

    public void updateFood(Food food){
        UpdateFoodEvent event = new UpdateFoodEvent();
        //TODO server call

        bus.post(event);
    }

    public void getFoodDetails(int id){
        GetFoodDetailsEvent event = new GetFoodDetailsEvent();

        //TODO server call
        bus.post(event);

    }
}
