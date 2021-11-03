package main.wsapp.models;


import javax.ws.rs.FormParam;

public class User {
    @FormParam("email")
    private String email;
    @FormParam("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
