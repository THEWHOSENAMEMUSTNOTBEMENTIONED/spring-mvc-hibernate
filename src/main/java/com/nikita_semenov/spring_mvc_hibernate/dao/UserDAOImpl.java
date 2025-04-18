package com.nikita_semenov.spring_mvc_hibernate.dao;

import com.nikita_semenov.spring_mvc_hibernate.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    // Метод для создания нового пользователя
    @Override
    public void createUser(User user) {
        entityManager.persist(user);  // Используем persist для добавления нового пользователя
    }

    // Метод для обновления существующего пользователя
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);  // Используем merge для обновления существующего пользователя
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);  // Ищем пользователя по ID
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();  // Удаляем пользователя по ID
    }
}
