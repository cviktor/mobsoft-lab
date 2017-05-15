package hu.bme.iemqra.mobsoft.mobsoft.interactor.user;

import java.io.IOException;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.events.UserChangedEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.UserApi;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class UserInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    UserApi api;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String userName, String password){
        UserChangedEvent event = new UserChangedEvent();
        try {
            hu.bme.iemqra.mobsoft.mobsoft.network.model.User u = api.loginPost(userName, password).execute().body();
            User user = new User();
            user.setUserName(u.getUserName());
            user.setIsAdmin(u.getIsAdmin());
            event.setUser(user);
            repository.setUser(user);
        } catch (IOException e) {
            event.setThrowable(e);
        }

        bus.post(event);
    }
}
