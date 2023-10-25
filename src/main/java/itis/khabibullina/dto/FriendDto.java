package itis.khabibullina.dto;

import java.sql.Date;

public class FriendDto {
    private String name;

    private Date dateOfBirth;

    private String zodiacSign;

    private String city;

    public FriendDto(String name, Date dateOfBirth, String zodiacSign, String city) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.zodiacSign = zodiacSign;
        this.city = city;
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
