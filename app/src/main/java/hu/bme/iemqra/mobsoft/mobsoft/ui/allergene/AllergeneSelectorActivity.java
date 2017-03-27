package hu.bme.iemqra.mobsoft.mobsoft.ui.allergene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.R;

public class AllergeneSelectorActivity extends AppCompatActivity implements AllergeneSelectorScreen {

    @Inject
    AllergeneSelectorPresenter allergeneSelectorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergene_selector);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        allergeneSelectorPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        allergeneSelectorPresenter.detachScreen();
    }

    @Override
    public void showAllergens() {

    }

    @Override
    public void getAllergens() {

    }
}
