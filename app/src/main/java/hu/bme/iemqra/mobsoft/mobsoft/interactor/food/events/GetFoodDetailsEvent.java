package hu.bme.iemqra.mobsoft.mobsoft.interactor.food.events;

import hu.bme.iemqra.mobsoft.mobsoft.model.Food;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetFoodDetailsEvent {
    private Throwable throwable;
    private Food food;

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
