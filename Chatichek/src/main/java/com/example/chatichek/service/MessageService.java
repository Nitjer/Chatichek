package com.example.chatichek.service;

import com.example.chatichek.entity.Message;
import com.example.chatichek.repository.ChaticRepository;
import com.example.chatichek.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message findByMessageId(Integer messageId){
        return messageRepository.findByMessageId(messageId);
    }

    public void deleteById(Integer messageId) {
        messageRepository.deleteById(messageId);
    }
}
