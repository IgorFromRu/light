package com.street.light.mapper;

import com.street.light.dto.MessageDto;
import com.street.light.model.Message;

public class MessageMapper {

    public MessageDto dto(Message message){
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setCreateTime(message.getCreateTime());
        messageDto.setText(message.getText());
        messageDto.setUserId(message.getUserId());
        messageDto.setMessageId(message.getMessageId());
        return messageDto;
    }

    public Message model(MessageDto messageDto){
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setCreateTime(messageDto.getCreateTime());
        message.setText(messageDto.getText());
        message.setUserId(messageDto.getUserId());
        message.setMessageId(messageDto.getMessageId());
        return message;
    }
}
