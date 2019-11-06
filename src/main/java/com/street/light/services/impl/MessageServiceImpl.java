package com.street.light.services.impl;

import com.street.light.repository.MessageRepisitory;
import com.street.light.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepisitory messageRepisitory;
}
