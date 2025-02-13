package com.nikita_semenov.spring_mvc_hibernate.dao;

import com.nikita_semenov.spring_mvc_hibernate.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
}
