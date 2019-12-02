package com.street.light.mapper;

import com.street.light.controllers.UserController;
import com.street.light.dto.MessageDto;
import com.street.light.dto.UserDto;
import com.street.light.model.Message;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageMapper {

    @Autowired
    UserMapper userMapper;

    public MessageDto messageDto(Message message){

        if(message == null) {
            return null;
        }
        MessageDto messageDto = new MessageDto();

        messageDto.setId(message.getId());
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        messageDto.setUser(userMapper.dto(message.getUser()));
        messageDto.setParent(parentDto(message.getParent()));
        if(message.getMessages() != null){
            List<MessageDto> listDto = new ArrayList<>();
            for (Message m : message.getMessages()) {
                listDto.add(messageDto(m));
            }
            messageDto.setMessages(listDto);
        }

        return messageDto;
    }

    public Message messageModel(MessageDto messageDto){

        if(messageDto == null) {
            return null;
        }
        Message message = new Message();

        message.setId(messageDto.getId());
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        message.setUser(userMapper.model(messageDto.getUser()));
        message.setParent(parentModel(messageDto.getParent()));
        if (messageDto.getMessages() != null){
            List<Message> list = new ArrayList<>();
            for (MessageDto m : messageDto.getMessages()) {
                list.add(messageModel(m));
            }
            message.setMessages(list);
        }
        return message;
    }

    public MessageDto parentDto(Message message){

        MessageDto messageDto = new MessageDto();

        messageDto.setId(message.getId());
        return messageDto;
    }

    public Message parentModel(MessageDto messageDto){

        Message message = new Message();

        message.setId(messageDto.getId());
        return message;
    }
}
