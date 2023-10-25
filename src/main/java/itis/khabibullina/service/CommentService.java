package itis.khabibullina.service;

import itis.khabibullina.dto.*;
import itis.khabibullina.model.*;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAll();

    List<CommentDto> getAllByPostId(int id);

    CommentDto get(int id);

    void save(Comment comment);

    void update(Comment comment);

    void delete(int id);
}
