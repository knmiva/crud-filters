package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    public User(){
    }

    public User(String name, String role, String password, String login, String email, String country, String mobile) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.login = login;
        this.email = email;
        this.country = country;
        this.mobile = mobile;
    }

    public User(long id, String name, String role, String password, String login, String email, String country, String mobile) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.login = login;
        this.email = email;
        this.country = country;
        this.mobile = mobile;
    }

    public User(long id, String name, String password, String login, String email, String country, String mobile) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;
        this.email = email;
        this.country = country;
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "id = " + id + "; role = " + role + "; name = " + name + "; password = " + password + "; login = " + login + "; email = " + email + ";" +
                " country = " + country + "; mobile = " + mobile;
    }
}
