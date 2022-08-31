package com.wavemaker.manager;

import com.wavemaker.model.User;

import java.util.List;

public interface UserManager {
    void addUser(User user);
    void deleteUser(String Email);
    List<User> displayUsers();
    int searchUserId(String email);
}
