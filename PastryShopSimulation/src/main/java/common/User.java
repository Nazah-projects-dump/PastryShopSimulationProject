package common;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String userId;
    protected String name;
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public abstract void showDashboard();

    public abstract boolean login(String name, String password);

    public void logout(){
        //add later
    }
}
