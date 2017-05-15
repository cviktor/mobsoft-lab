package hu.bme.iemqra.mobsoft.mobsoft.ui.allergene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuActivity;

public class AllergeneSelectorActivity extends AppCompatActivity implements AllergeneSelectorScreen {

    @Inject
    AllergeneSelectorPresenter allergeneSelectorPresenter;
    private AllergeneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergene_selector);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ListView list = (ListView) findViewById(R.id.allergene_list);
        adapter = new AllergeneAdapter(this, 0, new ArrayList<Allergene>());
        adapter.setEditable(true);
        list.setAdapter(adapter);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        allergeneSelectorPresenter.attachScreen(this);
        allergeneSelectorPresenter.getAllergenes();
    }

    @Override
    protected void onStop() {
        super.onStop();
        allergeneSelectorPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_food) {
            allergeneSelectorPresenter.navigateToFoodMenu();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showAllergens(List<Allergene> allergeneList) {
        adapter.clear();
        adapter.addAll(allergeneList);
    }

    @Override
    public void navigateToFoodMenu() {
        Intent i = new Intent(this, FoodMenuActivity.class);
        i.putExtra("backToAllergene", true);
        startActivity(i);
    }
}
