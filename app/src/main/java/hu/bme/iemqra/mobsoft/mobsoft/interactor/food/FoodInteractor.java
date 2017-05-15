package hu.bme.iemqra.mobsoft.mobsoft.interactor.food;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        try {
           List<hu.bme.iemqra.mobsoft.mobsoft.network.model.Food> foods = api.foodGet().execute().body();

            ArrayList<Food> food = new ArrayList<Food>();
            for (hu.bme.iemqra.mobsoft.mobsoft.network.model.Food f : foods) {
                food.add(toModel(f));
            }
            event.setFoodList(food);
        } catch (IOException e) {
            e.printStackTrace();
            event.setThrowable(e);
        }

        bus.post(event);
    }

    public void updateFood(Food food){
        UpdateFoodEvent event = new UpdateFoodEvent();

        bus.post(event);
    }

    public void getFoodDetails(int id){
        GetFoodDetailsEvent event = new GetFoodDetailsEvent();

        try {
            hu.bme.iemqra.mobsoft.mobsoft.network.model.Food f = api.foodIdGet(new BigDecimal(id)).execute().body();

            event.setFood(toModel(f));
            event.setEditable(true);

        } catch (IOException e) {
            event.setThrowable(e);
        }
        bus.post(event);

    }

    public Food toModel(hu.bme.iemqra.mobsoft.mobsoft.network.model.Food f){
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

        return model;
    }
}
