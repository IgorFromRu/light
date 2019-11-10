package com.street.light.dto;


import org.apache.catalina.User;
import sun.plugin2.message.Message;

import java.time.LocalDateTime;
import java.util.List;

public class MessageDto {

    int id;

    LocalDateTime createTime;

    String text;

    UserDto user;

    MessageDto parent;

    List<MessageDto> messages;

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

    public void setUser(UserDto user) {
        this.user = user;
    }

    public MessageDto getParent() {
        return parent;
    }

    public void setParent(MessageDto parent) {
        this.parent = parent;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }
}
