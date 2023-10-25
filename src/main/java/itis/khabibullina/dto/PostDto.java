package itis.khabibullina.dto;

import java.sql.Date;

public class PostDto {
    private int id;

    private String userLogin;

    private String content;

    private Date dateOfCreation;

    public PostDto(int id, String userLogin, String content, Date dateOfCreation) {
        this.id = id;
        this.userLogin = userLogin;
        this.content = content;
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getContent() {
        return content;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
}
