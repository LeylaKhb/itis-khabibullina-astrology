package itis.khabibullina.service;

import itis.khabibullina.dto.UserDto;
import itis.khabibullina.model.User;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    T get(int id);

    void save(T entity);
}
