package itis.khabibullina.dao.impl;

import itis.khabibullina.dao.*;
import itis.khabibullina.model.Friend;
import itis.khabibullina.model.User;
import itis.khabibullina.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImpl implements FriendDao<Friend> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Friend get(int id) {
        String sql = "SELECT * FROM FRIENDS WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Friend friend = null;

            if (resultSet != null) {
                while (resultSet.next()) {
                    friend = new Friend(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getDate("date_of_birth"),
                            resultSet.getString("zodiac_sign"),
                            resultSet.getString("name"),
                            resultSet.getString("city")

                    );
                }
            }
            return friend;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Friend> getAll() {
        String sql = "SELECT * from friends";
        return getFriends(sql);
    }

    private List<Friend> getFriends(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Friend> friends = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    friends.add(
                            new Friend(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("user_id"),
                                    resultSet.getDate("date_of_birth"),
                                    resultSet.getString("zodiac_sign"),
                                    resultSet.getString("name"),
                                    resultSet.getString("city")

                            )
                    );
                }
            }
            return friends;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Friend friend) {
        String sql = "insert into friends (user_id, name, date_of_birth, zodiac_sign, city) values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, friend.getUserId());
            preparedStatement.setString(2, friend.getName());
            preparedStatement.setDate(3, friend.getDateOfBirth());
            preparedStatement.setString(4, friend.getZodiacSign());
            preparedStatement.setString(5, friend.getCity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Friend> getAllByUserId(int userId) {
        String sql = "SELECT * from friends WHERE user_id=" + userId;
        return getFriends(sql);
    }

    @Override
    public void update(Friend friend) {
        String sql = "UPDATE friends SET " +
                "name = ?, date_of_birth = ?, zodiac_sign = ?, city = ?" +
                " WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, friend.getName());
            preparedStatement.setDate(2, friend.getDateOfBirth());
            preparedStatement.setString(3, friend.getZodiacSign());
            preparedStatement.setString(4, friend.getCity());
            preparedStatement.setInt(5, friend.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM friends WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
