package ru.kata.spring.boot_security.demo.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String allUsers(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping
    public String changeUser(@RequestParam("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(id,user);
        return "redirect:/admin";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


}
