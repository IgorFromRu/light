package com.street.light.mapper;

import com.street.light.dto.MessageDto;
import com.street.light.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDto MessegeDto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        messageDto.setUser(message.getUser());
        messageDto.setParent(messageDto.getParent());
        messageDto.setMessages(message.getMessages());
        return messageDto;
    }

    public Message MessegeModel(MessageDto messageDto){
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        message.setUser(messageDto.getUser());
        message.setParent(messageDto.getParent());
        message.setMessages(messageDto.getMessages());
        return message;
    }
}
