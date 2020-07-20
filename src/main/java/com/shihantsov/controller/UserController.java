package com.shihantsov.controller;

import com.shihantsov.entity.User;
import com.shihantsov.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/name")

    public String printCat(@ModelAttribute User user) {
        if (user.getId() == null) {
            System.out.println("у user нет айди,его не было в базе");
        } else {
            System.out.println("У user есть айди, уже был в базе");
        }
        userService.addOrUpdate(user);
        return "redirect:/name";
    }

    @GetMapping("/cat")
    //http://localhost:8080/cat
    public String index(Model model) {
        model.addAttribute("cat", userService.getAll());
        return "cat";
    }

    @GetMapping("/user/removeByName")
    public String removeBuName(@RequestParam String name) {
        userService.removeByName(name);
        return "redirect:/user";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam Integer id, Model model) {
        User editUsers = userService.getById(id);
        model.addAttribute("user", editUsers);
        return "Useredit";
    }
}
