package itis.khabibullina.service;

import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.dto.PostDto;
import itis.khabibullina.model.Comment;
import itis.khabibullina.model.Post;

import java.util.List;

public interface PostService {
    List<PostDto> getAll();

    PostDto get(int id);

    void save(Post post);
}
