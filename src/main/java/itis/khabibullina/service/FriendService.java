package itis.khabibullina.service;


import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.model.Friend;

import java.util.List;


public interface FriendService {
    List<FriendDto> getAll();

    FriendDto get(int id);

    List<FriendDto> getAllByUserId(int userId);

    void save(Friend friend);

    void update(Friend friend);

    void delete(int id);
}
