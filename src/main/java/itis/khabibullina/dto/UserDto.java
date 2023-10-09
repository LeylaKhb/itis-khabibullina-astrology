package itis.khabibullina.dto;

import java.sql.Date;

public class UserDto {

    private String name;

    private Date dateOfBirth;

    private String city;

    private String login;

    private String password;


    public UserDto(String name, Date dateOfBirth, String city, String login, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
