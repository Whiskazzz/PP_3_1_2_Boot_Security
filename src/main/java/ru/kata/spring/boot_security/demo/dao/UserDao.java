package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserDao{

    void saveUser(User user);

    void removeUserById(long id);

    public User getUserById(long id);
    public User getUserByName(String name);
    public void changeUserById(long id, User user);

    List<User> getAllUsers();


}
