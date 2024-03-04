package ru.javamentor.SpringBoot.service;

import ru.javamentor.SpringBoot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    void cleanTable();
}
