package itis.khabibullina.dao;

import java.sql.Date;
import java.util.List;

public interface ZodiacSignLuckDao<T> {
    T get(int id);

    List<T> getAll();

    void save (T t);

    T get(Date date);

}
