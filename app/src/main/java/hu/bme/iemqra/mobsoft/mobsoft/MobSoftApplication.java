package hu.bme.iemqra.mobsoft.mobsoft;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarContext;

import hu.bme.iemqra.mobsoft.mobsoft.ui.UIModule;
import io.fabric.sdk.android.Fabric;


public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;
    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerMobSoftApplicationComponent.builder().
                        uIModule(new UIModule(this)).build();

        SugarContext.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        SugarContext.terminate();
        super.onTerminate();
    }
}
