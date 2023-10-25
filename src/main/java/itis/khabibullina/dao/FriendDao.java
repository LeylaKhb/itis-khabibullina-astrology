package itis.khabibullina.dao;

import itis.khabibullina.dto.FriendDto;

import java.util.List;

public interface FriendDao<T> extends Dao<T>{
    List<T> getAllByUserId(int userId);
}
