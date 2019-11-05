package com.street.light.repository.ram;

import com.street.light.dto.UserDto;
import com.street.light.model.User;
import com.street.light.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
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
        User userUpdate = getById(id);
        if (user.getFirstName()!=null) userUpdate.setFirstName(user.getFirstName());
        if (user.getLastName()!=null) userUpdate.setLastName(user.getLastName());
        if (user.getAge()!=null) userUpdate.setAge(user.getAge());
        return userUpdate;
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        for(Map.Entry<Integer,User> map : users.entrySet()){
            list.add(map.getValue());
        }
        return list;
    }
}
