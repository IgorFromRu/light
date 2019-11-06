package com.street.light.mapper;

import com.street.light.dto.MessageDto;
import com.street.light.model.Message;

public class MessageMapper {

    public MessageDto messageDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        messageDto.setUser(message.getUser());
        messageDto.setParent(messageDto.getParent());
        messageDto.setMessages(message.getMessages());
        return messageDto;
    }

    public Message messageModel(MessageDto messageDto){
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        message.setUser(messageDto.getUser());
        message.setParent(message.getParent());
        message.setMessages(messageDto.getMessages());
        return message;
    }
}
