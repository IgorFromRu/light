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
    public User update(int id, UserDto userDto) {
        User userUpdate = new User();
        if (getById(id) == null) throw new NullPointerException("User not found");

        if (userDto.getFirstName()!=null) userUpdate.setFirstName(userDto.getFirstName());
        else userUpdate.setFirstName(users.get(id).getFirstName());

        if (userDto.getLastName()!=null) userUpdate.setLastName(userDto.getLastName());
        else userUpdate.setLastName(users.get(id).getLastName());

        if (userDto.getAge()!=null) userUpdate.setAge(userDto.getAge());
        else userUpdate.setAge(users.get(id).getAge());

        userUpdate.setId(id);
        users.put(id,userUpdate);
        return userUpdate;
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
