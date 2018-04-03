package entity;

public class User {
    String role;
    String login;
    String password;

    public User(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
