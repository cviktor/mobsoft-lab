package hu.bme.iemqra.mobsoft.mobsoft.ui.main;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.UserInteractor;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.events.UserChangedEvent;
import hu.bme.iemqra.mobsoft.mobsoft.ui.Presenter;

import static hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(final String userName, final String password){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.login(userName, password);
            }
        });
    }

    public void onEventMainThread(UserChangedEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
        } else {
            if (screen != null && event.getUser() != null) {
                screen.showMessage("Sikeres bejelentkezés");
                screen.navigateToAllergenes();
            }
        }
    }
}
