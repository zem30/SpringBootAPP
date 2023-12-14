package ru.zem.springbootapp.springbootapp.service;

import ru.zem.springbootapp.springbootapp.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void save(User user);

    User show(int id);

    void deleteUser(int id);

    void update(User user);
}
