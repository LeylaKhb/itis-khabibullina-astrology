package itis.khabibullina.dao;

import java.sql.Date;

public interface UserDao<T> extends Dao<T>{
    T get(String login);

    void update(String login, String password, Date dateOfBirth, String name, String city);
}
