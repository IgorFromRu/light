package com.street.light.repository;

import com.street.light.model.Message;

public interface MessageRepository {

    Message create(Message message);

    Message getById(int id);
}
