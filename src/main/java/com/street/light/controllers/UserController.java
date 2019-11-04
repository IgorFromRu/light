package com.street.light.controllers;

import com.street.light.dto.UserDto;
import com.street.light.mapper.UserMapper;
import com.street.light.model.User;
import com.street.light.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto){
        User model = userMapper.model(userDto);
        User user = userService.create(model);
        return userMapper.dto(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") int id){
        User user = userService.getById(id);
        UserDto dto = userMapper.dto(user);
        return dto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public String delite(@PathVariable("id") int id){
        userService.delete(id);
        return "Deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id,@RequestBody UserDto userDto){
        User model = userMapper.model(userDto);
        User user = userService.create(model);
        userService.update(id,user);
        return "Upated";
    }
}
