package com.street.light.services.impl;

import com.street.light.model.Message;
import com.street.light.repository.MessageRepository;
import com.street.light.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message create(Message message) {
        return messageRepository.create(message);
    }

    @Override
    public Message getById(int id) {
        Message message = messageRepository.getById(id);
        if(message == null) {
            throw new IllegalArgumentException("message not found id =" + id);
        }
        return message;
    }
}
