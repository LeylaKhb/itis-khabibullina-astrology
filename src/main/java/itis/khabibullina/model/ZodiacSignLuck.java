package itis.khabibullina.model;

import java.sql.Date;

public class ZodiacSignLuck {
    private int id;

    private Date dateOfLuck;

    private String luckyZodiacSign;

    private String unluckyZodiacSign;

    public ZodiacSignLuck(int id, Date dateOfLuck, String luckyZodiacSign, String unluckyZodiacSign) {
        this.id = id;
        this.dateOfLuck = dateOfLuck;
        this.luckyZodiacSign = luckyZodiacSign;
        this.unluckyZodiacSign = unluckyZodiacSign;
    }

    public ZodiacSignLuck(Date dateOfLuck, String luckyZodiacSign, String unluckyZodiacSign) {
        this.dateOfLuck = dateOfLuck;
        this.luckyZodiacSign = luckyZodiacSign;
        this.unluckyZodiacSign = unluckyZodiacSign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfLuck() {
        return dateOfLuck;
    }

    public void setDateOfLuck(Date dateOfLuck) {
        this.dateOfLuck = dateOfLuck;
    }

    public String getLuckyZodiacSign() {
        return luckyZodiacSign;
    }

    public void setLuckyZodiacSign(String luckyZodiacSign) {
        this.luckyZodiacSign = luckyZodiacSign;
    }

    public String getUnluckyZodiacSign() {
        return unluckyZodiacSign;
    }

    public void setUnluckyZodiacSign(String unluckyZodiacSign) {
        this.unluckyZodiacSign = unluckyZodiacSign;
    }
}
