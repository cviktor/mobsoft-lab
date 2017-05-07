package hu.bme.iemqra.mobsoft.mobsoft.interactor.user;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.user.events.UserChangedEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class UserInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String userName, String password){
        UserChangedEvent event = new UserChangedEvent();
        //TODO server call
        User user = new User();
        user.setUserName("Viktor");
        event.setUser(user);
        repository.setUser(user);
        bus.post(event);
    }

    public void logout(String userName, String password){
        //TODO server call
        UserChangedEvent event = new UserChangedEvent();
        repository.removeUser();
        bus.post(event);
    }
}
