package com.study.tech.service.impl;

import com.study.tech.model.User;
import com.study.tech.repository.UserRepository;
import com.study.tech.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        boolean userHasId = userToCreate.getId() != null;
        var usernameToCreate = userToCreate.getUsername();
        boolean isUsernameUnique = userRepository.findByUsername(usernameToCreate) == null;
        if (userRepository.existsById(userToCreate.getId()) && userHasId || !isUsernameUnique) {
            throw new IllegalArgumentException("User already exists.");
        }

        return userRepository.save(userToCreate);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
