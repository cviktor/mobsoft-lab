package hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.events;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class GetAllergenesEvent {
    private List<Allergene> allergeneList;
    private Throwable throwable;


    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public List<Allergene> getAllergeneList() {
        return allergeneList;
    }

    public void setAllergeneList(List<Allergene> allergeneList) {
        this.allergeneList = allergeneList;
    }
}
