package itis.khabibullina.dto;


public class CommentDto {
    private String userLogin;

    private int postId;

    private String content;


    public CommentDto(String userLogin, int postId, String content) {
        this.userLogin = userLogin;
        this.postId = postId;
        this.content = content;
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
