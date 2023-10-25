package itis.khabibullina.dao.impl;

import itis.khabibullina.dao.CommentDao;
import itis.khabibullina.dao.Dao;
import itis.khabibullina.model.Comment;
import itis.khabibullina.server.LoginServlet;
import itis.khabibullina.util.DatabaseConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao<Comment> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Comment get(int id) {
        String sql = "SELECT * FROM comments WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Comment comment = null;

            if (resultSet != null) {
                while (resultSet.next()) {
                    comment = new Comment(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("user_login"),
                            resultSet.getInt("post_id"),
                            resultSet.getString("content")
                    );
                }
            }
            return comment;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> getAll() {
        String sql = "SELECT * from comments";
        return getComments(sql);

    }

    private List<Comment> getComments(String sql) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Comment> comments = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    comments.add(
                            new Comment(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("user_id"),
                                    resultSet.getString("user_login"),
                                    resultSet.getInt("post_id"),
                                    resultSet.getString("content")

                            )
                    );
                }
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Comment comment) {
        String sql = "insert into comments (user_id, user_login, post_id, content) values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, comment.getUserId());
            preparedStatement.setString(2, comment.getUserLogin());
            preparedStatement.setInt(3, comment.getPostId());
            preparedStatement.setString(4, comment.getContent());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Comment comment) {
        String sql = "UPDATE comments SET " +
                "content = ?" +
                " WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setInt(2, comment.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM comments WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> getAllByPostId(int postId) {
        String sql = "SELECT * from comments WHERE post_id = " + postId;
        return getComments(sql);
    }
}
