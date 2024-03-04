package ru.javamentor.SpringBoot.dao;

import ru.javamentor.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);

    void removeUser(Long id);

    void updateUser(User user);

    void cleanTable();

}