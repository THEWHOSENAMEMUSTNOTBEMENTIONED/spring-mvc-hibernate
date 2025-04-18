package com.nikita_semenov.spring_mvc_hibernate.controller;

import com.nikita_semenov.spring_mvc_hibernate.entity.User;
import com.nikita_semenov.spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/user/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());  // Новый объект User для создания
        return "add-user";
    }

    // Для добавления нового пользователя
    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);  // Создание нового пользователя
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String showEditUserForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);  // Получение пользователя для редактирования
        model.addAttribute("user", user);
        return "edit-user";
    }

    // Для редактирования существующего пользователя
    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);  // Обновление существующего пользователя
        return "redirect:/users";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);  // Удаление пользователя
        return "redirect:/users";
    }
}
