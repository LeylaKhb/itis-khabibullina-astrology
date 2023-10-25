package itis.khabibullina.model;

import java.sql.Date;

public class Post {
    private int id;

    private int userId;

    private String userLogin;

    private String content;

    private Date dateOfCreation;

    public Post(int id, int userId, String userLogin, String content, Date dateOfCreation) {
        this.id = id;
        this.userId = userId;
        this.userLogin = userLogin;
        this.content = content;
        this.dateOfCreation = dateOfCreation;
    }

    public Post(int userId, String userLogin, String content, Date dateOfCreation) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.content = content;
        this.dateOfCreation = dateOfCreation;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
