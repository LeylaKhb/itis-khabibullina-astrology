package itis.khabibullina.service.impl;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.UserDto;
import itis.khabibullina.model.User;
import itis.khabibullina.server.LoginServlet;
import itis.khabibullina.service.UserService;
import itis.khabibullina.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserDao<User> dao = new UserDaoImpl();

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    public List<UserDto> getAll() {
        return dao.getAll().stream().map(
                u -> new UserDto(u.getName(), u.getDateOfBirth(), u.getZodiacSign(), u.getCity(), u.getLogin(), u.getPassword())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        User u = dao.get(id);
        return new UserDto(u.getName(), u.getDateOfBirth(), u.getZodiacSign(), u.getCity(), u.getLogin(), u.getPassword());
    }

    @Override
    public UserDto get(String login) {
        User u = dao.get(login);
        return new UserDto(u.getName(), u.getDateOfBirth(), u.getZodiacSign(), u.getCity(), u.getLogin(), u.getPassword());
    }

    @Override
    public void save(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        dao.save(user);
    }
}
