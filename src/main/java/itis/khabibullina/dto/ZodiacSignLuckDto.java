package itis.khabibullina.dto;

import java.sql.Date;

public class ZodiacSignLuckDto {
    private Date dateOfLuck;

    private String luckyZodiacSign;

    private String unluckyZodiacSign;

    public ZodiacSignLuckDto(Date dateOfLuck, String luckyZodiacSign, String unluckyZodiacSign) {
        this.dateOfLuck = dateOfLuck;
        this.luckyZodiacSign = luckyZodiacSign;
        this.unluckyZodiacSign = unluckyZodiacSign;
    }

    public Date getDateOfLuck() {
        return dateOfLuck;
    }

    public String getLuckyZodiacSign() {
        return luckyZodiacSign;
    }

    public String getUnluckyZodiacSign() {
        return unluckyZodiacSign;
    }
}
