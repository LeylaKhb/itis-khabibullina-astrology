package itis.khabibullina.model;

import java.sql.Date;

public class User {

    private int id;

    private String login;

    private String password;

    private Date dateOfBirth;

    private String zodiacSign;

    private String name;

    private String city;

    public User(int id, String login, String password, Date dateOfBirth, String zodiacSign, String name, String city) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.name = name;
        this.city = city;
    }

    public User(String login, String password, Date dateOfBirth, String zodiacSign, String name, String city) {
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
