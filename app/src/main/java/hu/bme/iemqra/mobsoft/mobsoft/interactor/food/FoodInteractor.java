package hu.bme.iemqra.mobsoft.mobsoft.interactor.food;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodDetailsEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.GetFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events.UpdateFoodEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.FoodsApi;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class FoodInteractor {
    @Inject
    FoodsApi api;
    @Inject
    EventBus bus;

    public FoodInteractor() {
       MobSoftApplication.injector.inject(this);
    }

    public void getFood(){
        GetFoodEvent event = new GetFoodEvent();

        //TODO server call

        ArrayList<Food> food = new ArrayList<Food>();
        Food f = new Food();
        f.setName("Asd");
        f.setDetails("Details");
        f.setPrice(4000);
        f.setId(1);
        food.add(f);
        event.setFoodList(food);
        bus.post(event);
    }

    public void updateFood(Food food){
        UpdateFoodEvent event = new UpdateFoodEvent();
        //TODO server call

        bus.post(event);
    }

    public void getFoodDetails(int id){
        GetFoodDetailsEvent event = new GetFoodDetailsEvent();

        try {
            hu.bme.iemqra.mobsoft.mobsoft.network.model.Food f = api.foodIdGet(new BigDecimal(id)).execute().body();
            Food model = new Food();
            model.setId(f.getId());
            model.setName(f.getName());
            model.setDetails(f.getDetails());
            model.setPrice(f.getPrice());
            model.setComponents(f.getIngredients());

            ArrayList<Allergene> allergenes = new ArrayList<>();
            for(hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene a : f.getAllergens()){
                Allergene am = new Allergene();
                am.setId(a.getId());
                am.setName(a.getName());
                am.setChecked(a.getIsAllergic());
                allergenes.add(am);
            }
            model.setAllergenes(allergenes);

            event.setFood(model);

        } catch (IOException e) {
            event.setThrowable(e);
        }
        bus.post(event);

    }
}
