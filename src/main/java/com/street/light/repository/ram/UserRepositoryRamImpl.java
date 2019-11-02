package com.street.light.repository.ram;

import com.street.light.model.User;
import com.street.light.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepositoryRamImpl implements UserRepository {

    private Map<Integer, User> users = new HashMap<>();

    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public User create(User user) {
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public User update(int id, User user) {
        return null;
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }
}
