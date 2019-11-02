package com.street.light.repository;

import com.street.light.model.User;

public interface UserRepository {

    User create(User user);

    User getById(int id);

    User update(int id, User user);

    void delete(int id);
}
