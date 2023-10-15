package itis.khabibullina.dto;

import java.sql.Date;

public class UserDto {

    private String name;

    private Date dateOfBirth;

    private String zodiacSign;

    private String city;

    private String login;

    private String password;


    public UserDto(String name, Date dateOfBirth, String zodiacSign, String city, String login, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
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

    public String getZodiacSign() {
        return zodiacSign;
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
