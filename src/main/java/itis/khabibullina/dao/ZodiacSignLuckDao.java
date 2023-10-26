package itis.khabibullina.dao;

import java.sql.Date;
import java.util.List;

public interface ZodiacSignLuckDao<T> {
    T get(int id);

    List<T> getAll();

    List<T> getAllByName(String sign);

    void save (T t);

    T get(Date date);

}
