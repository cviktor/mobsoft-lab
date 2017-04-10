package hu.bme.iemqra.mobsoft.mobsoft.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.ui.allergene.AllergeneSelectorPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.fooddetails.FoodDetailsPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.foodmenu.FoodMenuPresenter;
import hu.bme.iemqra.mobsoft.mobsoft.ui.main.MainPresenter;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public FoodMenuPresenter provideFoodMenuPresenter() {
        return new FoodMenuPresenter();
    }

    @Provides
    @Singleton
    public FoodDetailsPresenter provideFoodDetailsPresenter() {
        return new FoodDetailsPresenter();
    }

    @Provides
    @Singleton
    public AllergeneSelectorPresenter provideAllergenSelectorPresenter() {
        return new AllergeneSelectorPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}
