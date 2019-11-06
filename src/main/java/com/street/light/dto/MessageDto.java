package com.street.light.dto;


import com.street.light.model.Message;
import com.street.light.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class MessageDto {

    int id;

    LocalDateTime createTime;

    String text;

    UserDto user;

    MessageDto parent;

    List<Message> messages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setId(user.getId());
        this.user.setFirstName(user.getFirstName());
        this.user.setLastName(user.getFirstName());
        this.user.setAge(user.getAge());
    }

    public MessageDto getParent() {
        return parent;
    }

    public void setParent(MessageDto parent) {
        this.parent = parent;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


}
