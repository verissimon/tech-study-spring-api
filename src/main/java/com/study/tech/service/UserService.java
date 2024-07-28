package com.study.tech.service;

import com.study.tech.model.User;


import java.util.List;

public interface UserService {
    User findById(String id);
    User create(User userToCreate);
    List<User> listAll();
    void delete(User user);
    User findByUsername(String username);

}
