package itis.khabibullina.service.impl;

import itis.khabibullina.dao.*;
import itis.khabibullina.dao.impl.CommentDaoImpl;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.model.Comment;
import itis.khabibullina.service.CommentService;
import itis.khabibullina.service.Service;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {
    private final Dao<Comment> dao = new CommentDaoImpl();

    @Override
    public List<CommentDto> getAll() {
        return dao.getAll().stream().map(
                c -> new CommentDto(c.getUserLogin(), c.getPostId(), c.getContent())
        ).collect(Collectors.toList());
    }

    @Override
    public CommentDto get(int id) {
        Comment p = dao.get(id);
        return new CommentDto(p.getUserLogin(),  p.getPostId(), p.getContent());
    }


    @Override
    public void save(Comment comment) {
        dao.save(comment);
    }

}
