package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    public void addRole(Role role) {
        userDao.saveRole(role);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.changeUserById(id, user);
    }

    @Override
    public Set<Role> findRollsbyId(String RoleIds) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getAllRoles()){
            if (RoleIds.contains(role.getId().toString())) {
                roles.add(role);
            }
        }
        return roles;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<Role> getAllRoles() {
        return userDao.getAllRoles();
    }
}
