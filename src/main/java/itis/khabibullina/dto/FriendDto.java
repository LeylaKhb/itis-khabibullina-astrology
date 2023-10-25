package itis.khabibullina.dto;

import java.sql.Date;

public class FriendDto {
    private int id;

    private String name;

    private Date dateOfBirth;

    private String zodiacSign;

    private String city;

    public FriendDto(int id, String name, Date dateOfBirth, String zodiacSign, String city) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.city = city;
    }

    public int getId() {
        return id;
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
}
