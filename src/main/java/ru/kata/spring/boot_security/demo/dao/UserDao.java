package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserDao{

    void saveUser(User user);
    public void saveRole(Role role);

    void removeUserById(long id);

    User getUserById(long id);
    User getUserByName(String name);
    void changeUserById(long id, User user);

    List<User> getAllUsers();
    List<Role> getAllRoles();


}
