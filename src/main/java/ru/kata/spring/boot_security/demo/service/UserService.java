package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    List<Role> getAllRoles();
    public void addRole(Role role);

    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(long id, User user);
    Set<Role> findRollsbyId(String RoleIds);
}
