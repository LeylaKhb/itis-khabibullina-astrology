package itis.khabibullina.dao.impl;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.model.User;
import itis.khabibullina.server.LoginServlet;
import itis.khabibullina.util.DatabaseConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM USERS WHERE id = " + id;
        return getUser(sql);
    }

    public User get(String login) {
        String sql = "SELECT * FROM USERS WHERE login = '" + login + "';";
        return getUser(sql);

    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET " +
                "login = ?, name = ?, date_of_birth = ?, zodiac_sign = ?, city = ?, password = ?" +
                " WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDate(3, user.getDateOfBirth());
            preparedStatement.setString(4, user.getZodiacSign());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    users.add(
                            new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password"),
                                    resultSet.getDate("date_of_birth"),
                                    resultSet.getString("zodiac_sign"),
                                    resultSet.getString("name"),
                                    resultSet.getString("city")

                            )
                    );
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into users (name, date_of_birth, zodiac_sign, city, login, password) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDate(2, user.getDateOfBirth());
            preparedStatement.setString(3, user.getZodiacSign());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUser(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            User user = null;

            if (resultSet != null) {
                while (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getDate("date_of_birth"),
                            resultSet.getString("zodiac_sign"),
                            resultSet.getString("name"),
                            resultSet.getString("city")

                    );
                }
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
