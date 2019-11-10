package com.street.light.mapper;

import com.street.light.dto.UserDto;
import com.street.light.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto dto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAge(user.getAge());
        return userDto;
    }
    public User model(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        return user;
    }
}
