package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class SugarOrmRepository implements Repository {


    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Allergene> getAllergenes() {
        return SugarRecord.listAll(Allergene.class);
    }

    @Override
    public void saveAllergene(Allergene allergene) {
        SugarRecord.saveInTx(allergene);
    }

    @Override
    public void updateAllergene(List<Allergene> allergenes) {
        SugarRecord.saveInTx(allergenes);
    }

    @Override
    public void removeAllergene(Allergene allergene) {
        SugarRecord.deleteInTx(allergene);
    }

    @Override
    public boolean isInDB(Allergene allergene) {
        return SugarRecord.findById(Allergene.class, allergene.getId()) != null;
    }

    @Override
    public User getUser() {
        return SugarRecord.listAll(User.class).get(0);
    }

    @Override
    public void setUser(User user) {
        removeUser();
        SugarRecord.saveInTx(user);
    }

    @Override
    public void removeUser() {
        SugarRecord.deleteAll(User.class);
    }
}
