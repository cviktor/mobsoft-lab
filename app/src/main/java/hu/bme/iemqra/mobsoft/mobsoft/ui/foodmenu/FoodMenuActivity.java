package hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneSelectorActivity;
import hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails.FoodDetailsActivity;

public class FoodMenuActivity extends AppCompatActivity implements FoodMenuScreen {

    private FoodAdapter adapter;

    @Inject
    FoodMenuPresenter foodMenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ListView list = (ListView) findViewById(R.id.food_list);
        adapter = new FoodAdapter(this, 0, new ArrayList<Food>());
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food f = (Food) parent.getItemAtPosition(position);
                foodMenuPresenter.navigateToFoodDetails(f.getId());
            }
        });
        MobSoftApplication.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        foodMenuPresenter.attachScreen(this);
        foodMenuPresenter.getFoodList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        foodMenuPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_allergene) {
            foodMenuPresenter.navigateToAllergeneList();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showFoodMenu(List<Food> foodList) {
        adapter.clear();
        adapter.addAll(foodList);
    }

    @Override
    public void navigateToAllergeneList() {
        Intent i = new Intent(this, AllergeneSelectorActivity.class);
        startActivity(i);
    }

    @Override
    public void navigateToFoodDetails(int id) {
        Intent i = new Intent(this, FoodDetailsActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    @Override
    public void navigateToLogin() {
        finish();
    }
}
