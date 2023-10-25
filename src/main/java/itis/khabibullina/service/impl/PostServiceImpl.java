package itis.khabibullina.service.impl;

import itis.khabibullina.dao.*;
import itis.khabibullina.dao.impl.*;
import itis.khabibullina.dto.*;
import itis.khabibullina.model.Post;
import itis.khabibullina.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    private final Dao<Post> dao = new PostDaoImpl();

    @Override
    public List<PostDto> getAll() {
        return dao.getAll().stream().map(
                p -> new PostDto(p.getId(), p.getUserLogin(), p.getContent(), p.getDateOfCreation())
        ).collect(Collectors.toList());
    }

    @Override
    public PostDto get(int id) {
        Post p = dao.get(id);
        return new PostDto(p.getId(), p.getUserLogin(), p.getContent(), p.getDateOfCreation());
    }

    @Override
    public void save(Post entity) {
        dao.save(entity);
    }

    @Override
    public void update(Post post) {
        dao.update(post);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
