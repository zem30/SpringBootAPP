package ru.zem.springbootapp.springbootapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zem.springbootapp.springbootapp.Model.User;
import ru.zem.springbootapp.springbootapp.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //работает
    @GetMapping("/user")
    public String getAllUser(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser", allUser);
        return "user/all-user";
    }


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

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "user/info-user";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
