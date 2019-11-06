package com.street.light.services;


import com.street.light.model.Message;

public interface MessageService {

    Message create(Message message);
    Message getById(int id);
}
