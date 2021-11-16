package Task1;

public class User {

    //PROPRIETIES
    private String username;
    private String password;

    //CONSTRUCTORS
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //GETTERS AND SETTERS
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
