package itis.khabibullina.dao.impl;

import itis.khabibullina.dao.Dao;
import itis.khabibullina.model.Post;
import itis.khabibullina.server.LoginServlet;
import itis.khabibullina.util.DatabaseConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements Dao<Post> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Post get(int id) {
        String sql = "SELECT * FROM POSTS WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Post post = null;

            if (resultSet != null) {
                while (resultSet.next()) {
                    post = new Post(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("user_login"),
                            resultSet.getString("content"),
                            resultSet.getDate("date_of_creation")
                    );
                }
            }
            return post;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from posts";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Post> posts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    posts.add(
                            new Post(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("user_id"),
                                    resultSet.getString("user_login"),
                                    resultSet.getString("content"),
                                    resultSet.getDate("date_of_creation")

                            )
                    );
                }
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Post post) {
        String sql = "insert into posts (user_id, user_login, content, date_of_creation) values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, post.getUserId());
            preparedStatement.setString(2, post.getUserLogin());
            preparedStatement.setString(3, post.getContent());
            preparedStatement.setDate(4, post.getDateOfCreation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
