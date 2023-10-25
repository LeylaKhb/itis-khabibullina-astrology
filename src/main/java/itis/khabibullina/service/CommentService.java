package itis.khabibullina.service;

import itis.khabibullina.dto.*;
import itis.khabibullina.model.*;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAll();

    CommentDto get(int id);



    void save(Comment comment);
}
