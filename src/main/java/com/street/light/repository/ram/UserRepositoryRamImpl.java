package com.street.light.repository.ram;

import com.street.light.model.User;
import com.street.light.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
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
        users.put(id,user);
        users.get(id).setId(id);
        return users.get(id);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    public List<User> list(){
        List<User> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, User>> iterator = users.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, User> pair = iterator.next();
            User value = pair.getValue();
            list.add(value);
        }
        return list;
    }
}
