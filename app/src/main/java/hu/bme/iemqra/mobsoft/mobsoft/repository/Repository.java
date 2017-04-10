package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Allergene> getAllergenes();

    void saveAllergene(Allergene allergene);

    void updateAllergene(List<Allergene> allergenes);

    void removeAllergene(Allergene allergene);

    boolean isInDB(Allergene allergene);

    User getUser();

    void setUser(User user);

    void removeUser();
}
