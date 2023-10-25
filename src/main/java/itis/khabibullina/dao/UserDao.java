package itis.khabibullina.dao;

import itis.khabibullina.model.User;


public interface UserDao<T> extends Dao<T>{
    T get(String login);

    void update(T user);
}
