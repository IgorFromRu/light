package com.street.light.mapper;

import com.street.light.dto.MessageDto;
import com.street.light.model.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageMapper {
    UserMapper userMapper = new UserMapper();
    public MessageDto messageDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        List<MessageDto> listDto = new ArrayList<>();
        messageDto.setId(message.getId());
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        messageDto.setUser(userMapper.dto(message.getUser()));
        if (message.getParent()!= null && !(message.getParent().equals(message.getUser()))){
            messageDto.setParent(messageDto(message.getParent()));
        }
        else messageDto.setParent(null);
        for (Message m :message.getMessages()) {
            listDto.add(messageDto(m));
        }
        messageDto.setMessages(listDto);
        return messageDto;
    }

    public Message messageModel(MessageDto messageDto){
        Message message = new Message();
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        List<Message> list = new ArrayList<>();
        message.setId(messageDto.getId());
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        message.setUser(userMapper.model(messageDto.getUser()));
        if (messageDto.getParent()!= null && !(messageDto.getParent().equals(messageDto.getUser()))){
            message.setParent(messageModel(messageDto.getParent()));
        }
        else message.setParent(null);
        for (MessageDto m :messageDto.getMessages()) {
            list.add(messageModel(m));
        }
        message.setMessages(list);
        return message;
    }
}
