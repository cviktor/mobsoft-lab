package hu.bme.iemqra.mobsoft.mobsoft;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

import android.app.Application;

import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;


public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder().
                        uIModule(new UIModule(this)).build();
    }
}
