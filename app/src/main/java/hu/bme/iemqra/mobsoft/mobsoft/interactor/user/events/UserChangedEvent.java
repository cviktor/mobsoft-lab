package hu.bme.iemqra.mobsoft.mobsoft.interactor.user.events;

import hu.bme.iemqra.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class UserChangedEvent {
    private User user;
    private Throwable throwable;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
