package hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;

public class FoodDetailsActivity extends AppCompatActivity implements FoodDetailsScreen {

    @Inject
    FoodDetailsPresenter foodDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        MobSoftApplication.injector.inject(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        foodDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        foodDetailsPresenter.detachScreen();
    }

    @Override
    public void showFoodDetails(Food food) {

    }
}
