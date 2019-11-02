package com.street.light.services.impl;

import com.street.light.model.User;
import com.street.light.repository.UserRepository;
import com.street.light.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User getById(int id) {
        User user = userRepository.getById(id);
        if(user == null) {
            throw new IllegalArgumentException("user not found, id=" + id);
        }
        return user;
    }

    @Override
    public User update(int id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
