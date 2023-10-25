package itis.khabibullina.service.impl;

import itis.khabibullina.dao.Dao;
import itis.khabibullina.dao.impl.FriendDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.model.Friend;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;

import java.util.List;
import java.util.stream.Collectors;

public class FriendServiceImpl implements FriendService {
    private final Dao<Friend> dao = new FriendDaoImpl();

    @Override
    public List<FriendDto> getAll() {
        return dao.getAll().stream().map(
                f -> new FriendDto(f.getName(), f.getDateOfBirth(), f.getZodiacSign(), f.getCity())
        ).collect(Collectors.toList());
    }

    @Override
    public FriendDto get(int id) {
        Friend f = dao.get(id);
        return new FriendDto(f.getName(), f.getDateOfBirth(), f.getZodiacSign(), f.getCity());
    }

    @Override
    public List<FriendDto> getAllByUserId(int userId) {
        return null;
    }

    @Override
    public void save(Friend friend) {

    }
}
