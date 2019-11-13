package com.street.light.repository.ram;

import com.street.light.model.Message;
import com.street.light.model.User;
import com.street.light.repository.MessageRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MessageRepositoryRamImpl implements MessageRepository {

    private Map<Integer,Message> messagesMap = new HashMap<>();

    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public Message create(Message message) {
        Message messageNew = new Message();
        int messageId = idGenerator.incrementAndGet();
        messageNew.setId(messageId);
        messageNew.setCreateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        messageNew.setText(message.getText());
        messageNew.setUser(message.getUser());
        messageNew.setParent(message.getParent());
        messageNew.setMessages(new ArrayList<>());
        if (messagesMap.get(message.getParent().getId()) != null){
            Message messageParent = messagesMap.get(message.getParent().getId());
            messageParent.getMessages().add(message);
        }
        messagesMap.put(messageId,messageNew);
        return messageNew;
    }

    @Override
    public Message getById(int id) {
        return messagesMap.get(id);
    }
}
