package com.nikita_semenov.spring_mvc_hibernate.dao;

import com.nikita_semenov.spring_mvc_hibernate.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();       // Получить всех пользователей
    void createUser(User user);     // Создание нового пользователя
    void updateUser(User user);     // Обновление существующего пользователя
    User getUser(int id);           // Получить пользователя по ID
    void deleteUser(int id);        // Удалить пользователя
}
