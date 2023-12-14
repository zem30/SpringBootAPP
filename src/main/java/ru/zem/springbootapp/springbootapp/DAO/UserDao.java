package ru.zem.springbootapp.springbootapp.DAO;

import ru.zem.springbootapp.springbootapp.Model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();

    void save(User user);


    User show(int id);

    void update(User user);

    void deleteUser(int id);
}
