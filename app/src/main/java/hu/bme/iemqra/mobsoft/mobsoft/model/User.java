package hu.bme.iemqra.mobsoft.mobsoft.model;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class User {
    private Long id = null;
    private String userName;
    private int isAdmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
