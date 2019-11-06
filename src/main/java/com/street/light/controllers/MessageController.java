package com.street.light.controllers;

import com.street.light.dto.MessageDto;
import com.street.light.mapper.MessageMapper;
import com.street.light.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    public MessageDto getById(@PathVeriable("id") int id){

    }
}
