package hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Food;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetFoodEvent {
    private List<Food> foodList;
    private Throwable throwable;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
