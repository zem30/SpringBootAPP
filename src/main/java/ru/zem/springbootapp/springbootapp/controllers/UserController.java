package ru.zem.springbootapp.springbootapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zem.springbootapp.springbootapp.Model.User;
import ru.zem.springbootapp.springbootapp.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //работает
    @GetMapping
    public String getAllUser(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "user/all-user";
    }

    //работает
    @GetMapping("/new")
    public String NewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new-user";
    }

    @PostMapping("/saveUser")
    public String creatUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "user/info-user";
    }
    //работает
    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user";
    }
    //работает
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
