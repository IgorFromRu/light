package com.street.light.controllers;

import com.street.light.dto.MessageDto;
import com.street.light.mapper.MessageMapper;
import com.street.light.model.Message;
import com.street.light.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto create(@RequestBody MessageDto messageDto){
        Message messageModel = messageMapper.MessegeModel(messageDto);
        Message message = messageService.create(messageModel);
        return messageMapper.MessegeDto(message);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageDto getById(@PathVariable("id") int id){
        Message message = messageService.getById(id);
        MessageDto messageDto = messageMapper.MessegeDto(message);
        return messageDto;
    }

}
