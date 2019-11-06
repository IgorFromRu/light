package com.street.light.repository.ram;

import com.street.light.model.Message;
import com.street.light.repository.MessageRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepositoryRamImpl implements MessageRepository {

    @Override
    public Message create(Message message) {
        return null;
    }
}
