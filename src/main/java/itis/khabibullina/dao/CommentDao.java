package itis.khabibullina.dao;

import java.util.List;

public interface CommentDao<T> extends Dao<T>{
    List<T> getAllByPostId(int postId);
}
