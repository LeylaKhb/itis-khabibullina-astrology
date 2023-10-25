package itis.khabibullina.dao.impl;

import itis.khabibullina.dao.ZodiacSignLuckDao;
import itis.khabibullina.model.ZodiacSignLuck;
import itis.khabibullina.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZodiacSignLuckDaoImpl implements ZodiacSignLuckDao<ZodiacSignLuck> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public ZodiacSignLuck get(int id) {
        String sql = "SELECT * FROM lucky_zodiac_signs WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return getZodiacSignLuck(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ZodiacSignLuck> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from lucky_zodiac_signs";
            ResultSet resultSet = statement.executeQuery(sql);
            List<ZodiacSignLuck> luckyZodiacSigns = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    luckyZodiacSigns.add(
                            new ZodiacSignLuck(
                                    resultSet.getInt("id"),
                                    resultSet.getDate("date_of_luck"),
                                    resultSet.getString("lucky_zodiac_sign"),
                                    resultSet.getString("unlucky_zodiac_sign")

                            )
                    );
                }
            }
            return luckyZodiacSigns;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(ZodiacSignLuck zodiacSignLuck) {
        String sql = "insert into lucky_zodiac_signs (date_of_luck, lucky_zodiac_sign, unlucky_zodiac_sign) values (?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, zodiacSignLuck.getDateOfLuck());
            preparedStatement.setString(2, zodiacSignLuck.getLuckyZodiacSign());
            preparedStatement.setString(3, zodiacSignLuck.getUnluckyZodiacSign());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ZodiacSignLuck get(Date date) {
        String sql = "SELECT * FROM lucky_zodiac_signs WHERE date_of_luck = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, date);

            ResultSet resultSet = preparedStatement.executeQuery();
            return getZodiacSignLuck(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ZodiacSignLuck getZodiacSignLuck(ResultSet resultSet) {
        try {
            ZodiacSignLuck zodiacSignLuck = null;

            if (resultSet != null) {
                while (resultSet.next()) {
                    zodiacSignLuck = new ZodiacSignLuck(
                            resultSet.getInt("id"),
                            resultSet.getDate("date_of_luck"),
                            resultSet.getString("lucky_zodiac_sign"),
                            resultSet.getString("unlucky_zodiac_sign")
                    );
                }
            }
            return zodiacSignLuck;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
