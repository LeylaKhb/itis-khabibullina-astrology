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
    private final CommentDao<Comment> dao = new CommentDaoImpl();

    @Override
    public List<CommentDto> getAll() {
        return dao.getAll().stream().map(
                c -> new CommentDto(c.getId(), c.getUserLogin(), c.getPostId(), c.getContent())
        ).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllByPostId(int id) {
        return dao.getAllByPostId(id).stream().map(
                c -> new CommentDto(c.getId(), c.getUserLogin(), c.getPostId(), c.getContent())
        ).collect(Collectors.toList());
    }

    @Override
    public CommentDto get(int id) {
        Comment c = dao.get(id);
        return new CommentDto(c.getId(), c.getUserLogin(),  c.getPostId(), c.getContent());
    }


    @Override
    public void save(Comment comment) {
        dao.save(comment);
    }

    @Override
    public void update(Comment comment) {
        dao.update(comment);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

}
