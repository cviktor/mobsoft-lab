package hu.bme.iemqra.mobsoft.mobsoft.model;

import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

@Table
public class Allergene {
    private int id;
    private String name;
    private Boolean isChecked;

    public Allergene() {
    }

    public Allergene(int id, String name, Boolean isChecked) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
