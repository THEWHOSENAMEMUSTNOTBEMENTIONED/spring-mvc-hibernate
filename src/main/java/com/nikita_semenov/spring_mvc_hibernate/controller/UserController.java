package com.nikita_semenov.spring_mvc_hibernate.controller;

import com.nikita_semenov.spring_mvc_hibernate.entity.User;
import com.nikita_semenov.spring_mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String showAddUserForm() {
        return "add-user";
    }

    @PostMapping("/user/add")
    public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String department) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setDepartment(department);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String showEditUserForm(@RequestParam("id") int id, Model model) {  // Исправлено на int id
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/user/edit")
    public String editUser(@RequestParam("id") int id, @RequestParam String name, @RequestParam String surname, @RequestParam String department) {
        User user = userService.getUser(id);
        user.setName(name);
        user.setSurname(surname);
        user.setDepartment(department);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") int id) {  // Исправлено на int id
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
