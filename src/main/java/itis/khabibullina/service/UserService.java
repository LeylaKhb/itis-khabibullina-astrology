package itis.khabibullina.service;

import itis.khabibullina.dto.UserDto;
import itis.khabibullina.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto get(int id);

    UserDto get(String login);

    void save(User user);

    void update(User user);

    void delete(int id);

}
