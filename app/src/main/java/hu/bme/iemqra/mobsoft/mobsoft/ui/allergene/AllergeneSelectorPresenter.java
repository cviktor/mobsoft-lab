package hu.bme.iemqra.mobsoft.mobsoft.ui.allergene;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.AllergeneInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.events.GetAllergenesEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class AllergeneSelectorPresenter extends Presenter<AllergeneSelectorScreen> {
    @Inject
    AllergeneInteractor allergeneInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(AllergeneSelectorScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void updateAllergenes(final ArrayList<Allergene> allergeneList){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                allergeneInteractor.updateAllergene(allergeneList);
            }
        });
    }

    public void getAllergenes(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                allergeneInteractor.getAllergenes();
            }
        });
    }

    public void onEventMainThread(GetAllergenesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showAllergens(new ArrayList<Allergene>());
            }
        } else {
            if (screen != null) {
                screen.showAllergens(event.getAllergeneList());
            }
        }
    }

    public void navigateToFoodMenu() {
        screen.navigateToFoodMenu();
    }
}
