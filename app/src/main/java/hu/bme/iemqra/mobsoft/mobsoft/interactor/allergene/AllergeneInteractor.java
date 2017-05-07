package hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.events.GetAllergenesEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class AllergeneInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public AllergeneInteractor(){
        MobSoftApplication.injector.inject(this);
        repository.open(null);
    }

    public void getAllergenes() {
        GetAllergenesEvent event = new GetAllergenesEvent();

        try {
            List<Allergene> allergeneList = repository.getAllergenes();
            event.setAllergeneList(allergeneList);
        } catch (Exception e) {
            event.setThrowable(e);
        } finally {
            bus.post(event);
        }
    }

    public void getAllergenesFromServer(){
        //TODO server call
    }

    public void updateAllergene(List<Allergene> allergenes){
        try {
            repository.updateAllergene(allergenes);
            //TODO server call
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
