package itis.khabibullina.dto;


public class CommentDto {
    private int id;
    private String userLogin;

    private int postId;

    private String content;


    public CommentDto(int id, String userLogin, int postId, String content) {
        this.id = id;
        this.userLogin = userLogin;
        this.postId = postId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

}
