package itis.khabibullina.model;

import java.sql.Date;

public class Friend {
    private int id;

    private int userId;

    private Date dateOfBirth;

    private String zodiacSign;

    private String name;

    private String city;

    public Friend(int id, int userId, Date dateOfBirth, String zodiacSign, String name, String city) {
        this.id = id;
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.name = name;
        this.city = city;
    }

    public Friend(int userId, Date dateOfBirth, String zodiacSign, String name, String city) {
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
