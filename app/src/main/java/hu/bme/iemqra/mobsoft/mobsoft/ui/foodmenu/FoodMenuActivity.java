package hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;

public class FoodMenuActivity extends AppCompatActivity implements FoodMenuScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        MobSoftApplication.injector.inject(this);
    }

    @Inject
    FoodMenuPresenter foodMenuPresenter;


    @Override
    protected void onStart() {
        super.onStart();
        foodMenuPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        foodMenuPresenter.detachScreen();
    }

    @Override
    public void showFoodMenu() {

    }
}
