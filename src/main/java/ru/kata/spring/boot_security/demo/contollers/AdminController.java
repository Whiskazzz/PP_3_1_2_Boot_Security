package ru.kata.spring.boot_security.demo.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @GetMapping()
    public String allUsers(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("listRoles", userService.getAllRoles());
        return "admin";
    }

    @PostMapping
    public String addUser(@RequestParam("rolesId") String rolesId, @ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userService.findRollsbyId(rolesId));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping
    public String changeUser(@RequestParam("id") long id, @RequestParam("rolesId") String rolesId, @ModelAttribute("user") User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setRoles(userService.findRollsbyId(rolesId));
        userService.updateUser(id,user);
        return "redirect:/admin";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }


}
