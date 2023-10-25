package itis.khabibullina.model;

import java.sql.Date;

public class Comment {
    private int id;

    private int userId;

    private String userLogin;

    private int postId;

    private String content;

    public Comment(int id, int userId, String userLogin, int postId, String content) {
        this.id = id;
        this.userId = userId;
        this.userLogin = userLogin;
        this.postId = postId;
        this.content = content;
    }

    public Comment(int userId, String userLogin, int postId, String content) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.postId = postId;
        this.content = content;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
