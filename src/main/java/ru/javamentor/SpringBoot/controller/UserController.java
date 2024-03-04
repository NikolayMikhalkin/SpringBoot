package ru.javamentor.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.SpringBoot.model.User;
import ru.javamentor.SpringBoot.service.UserService;

@Controller
@RequestMapping
public class UserController {

    private final UserService userServiceImp;

    @Autowired
    public UserController (UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userServiceImp.getAllUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String showAddForm(@ModelAttribute("user") User user) {
        return "createUser";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImp.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit-user")
    public  String showEditUserForm(@ModelAttribute("user") User user) {
        return "updateUser";
    }

    @PostMapping("/edit-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImp.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/remove-user")
    public String deleteUser(@RequestParam("id") Long id) {
        userServiceImp.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/clean-table")
    public String cleanTable() {
        userServiceImp.cleanTable();
        return "redirect:/users";
    }
}
