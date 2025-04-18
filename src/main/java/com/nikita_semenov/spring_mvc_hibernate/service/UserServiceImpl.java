package com.nikita_semenov.spring_mvc_hibernate.service;

import com.nikita_semenov.spring_mvc_hibernate.dao.UserDAO;
import com.nikita_semenov.spring_mvc_hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Для создания нового пользователя
    @Override
    public void saveUser(User user) {
        userDAO.createUser(user);  // Создание нового пользователя
    }

    // Для обновления существующего пользователя
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);  // Обновление существующего пользователя
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
