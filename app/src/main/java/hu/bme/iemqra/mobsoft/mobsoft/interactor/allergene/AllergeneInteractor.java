package hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.iemqra.mobsoft.mobsoft.MobSoftApplication;
import hu.bme.iemqra.mobsoft.mobsoft.interactor.allergene.events.GetAllergenesEvent;
import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.AllergenesApi;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.FoodsApi;
import hu.bme.iemqra.mobsoft.mobsoft.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class AllergeneInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    AllergenesApi api;

    public AllergeneInteractor() {
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

    public void getAllergenesFromServer() {
        try {
            List<hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene> result = api.allergenesGet(repository.getUser().getId().toString()).execute().body();
            for(hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene a : result){
                repository.saveAllergene(toModel(a));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void updateAllergene(List<Allergene> allergenes) {
        try {

            ArrayList<hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene> apiModel = new ArrayList<>();

            for (Allergene a : allergenes) {
                apiModel.add(toApi(a));
            }

            repository.updateAllergene(allergenes);
            api.allergenesPost(repository.getUser().getId().toString(), apiModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Allergene toModel(hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene a){
        Allergene model = new Allergene();

        model.setChecked(a.getIsAllergic());
        model.setId(a.getId());
        model.setName(a.getName());

        return model;
    }

    public hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene toApi(Allergene a){
        hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene model = new hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene();

        model.setIsAllergic(a.getChecked());
        model.setId(a.getId());
        model.setName(a.getName());

        return model;
    }
}
