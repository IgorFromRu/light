package com.street.light.services;

import com.street.light.dto.UserDto;
import com.street.light.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(int id);

    User update(int id, UserDto userDto);

    void delete(int id);

    List<User> list();
}
