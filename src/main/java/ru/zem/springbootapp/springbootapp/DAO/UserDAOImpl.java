package ru.zem.springbootapp.springbootapp.DAO;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.zem.springbootapp.springbootapp.Model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(int id) {
        entityManager.remove(show(id));
    }
}