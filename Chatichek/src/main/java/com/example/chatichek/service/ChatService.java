package com.example.chatichek.service;

import com.example.chatichek.entity.Chatic;
import com.example.chatichek.entity.Message;
import com.example.chatichek.repository.ChaticRepository;
import com.example.chatichek.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChaticRepository chaticRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public ChatService(ChaticRepository chaticRepository, MessageRepository messageRepository) {
        this.chaticRepository = chaticRepository;
        this.messageRepository = messageRepository;
    }

    // Получить все чаты
    public List<Chatic> getAllChats() {
        return chaticRepository.findAll();
    }

    // Получить все сообщения для конкретного чата
    public List<Message> getMessagesByChatId(Integer chatId) {
        return messageRepository.findByChatChatIdOrderByMessageTimeAsc(chatId);
    }

    // Сохранить новое сообщение
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
