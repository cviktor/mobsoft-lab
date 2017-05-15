package hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneAdapter;

public class FoodDetailsActivity extends AppCompatActivity implements FoodDetailsScreen {

    @Inject
    FoodDetailsPresenter foodDetailsPresenter;
    private Toolbar myToolbar;
    private TextView details;
    private ArrayAdapter<String> ingredientsAdapter;
    private AllergeneAdapter allergenesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        details = (TextView) findViewById(R.id.details_text);
        ListView ingredients = (ListView) findViewById(R.id.ingredient_list);
        ingredientsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        ingredients.setAdapter(ingredientsAdapter);

        ListView allergenes = (ListView) findViewById(R.id.allergene_list_details_view);
        allergenesAdapter = new AllergeneAdapter(this, 0, new ArrayList<Allergene>());
        allergenes.setAdapter(allergenesAdapter);

        MobSoftApplication.injector.inject(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        foodDetailsPresenter.attachScreen(this);
        foodDetailsPresenter.getFoodDetails(getIntent().getIntExtra("id", -1));
    }

    @Override
    protected void onStop() {
        super.onStop();
        foodDetailsPresenter.detachScreen();
    }

    @Override
    public void showFoodDetails(Food food, boolean editable) {
        myToolbar.setTitle(food.getName());
        allergenesAdapter.setEditable(editable);
        details.setText(food.getDetails());
        details.setEnabled(editable);

        ingredientsAdapter.clear();
        ingredientsAdapter.addAll(food.getComponents());

        allergenesAdapter.clear();
        allergenesAdapter.addAll(food.getAllergenes());
    }
}
