package hu.bme.iemqra.mobsoft.mobsoft.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.model.Allergene;
import hu.bme.iemqra.mobsoft.mobsoft.model.User;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class MemoryRepository implements Repository {

    List<Allergene> allergenes;
    User user;

    @Override
    public void open(Context context) {

        user = new User();
        user.setUserName("Viktor");
        user.setId(12323L);
        user.setIsAdmin(true);

        Allergene a1 = new Allergene(1,"Glutén", true);
        Allergene a2 = new Allergene(2,"Tej", false);

        allergenes = new ArrayList<Allergene>();
        allergenes.add(a1);
        allergenes.add(a2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    @Override
    public void saveAllergene(Allergene allergene) {
        allergenes.add(allergene);
    }

    @Override
    public void updateAllergene(List<Allergene> allergenes) {
        for (int i = 0; i < this.allergenes.size(); i++) {
            Allergene favourite = this.allergenes.get(i);
            for (Allergene todo : allergenes) {
                if (todo.getId() == favourite.getId()) {
                    this.allergenes.set(i, todo);
                }
            }
        }
    }

    @Override
    public void removeAllergene(Allergene allergene) {
        allergenes.remove(allergene);
    }

    @Override
    public boolean isInDB(Allergene allergene) {
        return allergenes.contains(allergene);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void removeUser() {
        this.user = null;
    }
}
