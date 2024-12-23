//package com.example.chatichek.repository;
//
//import com.example.chatichek.entity.Message;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface MessageRepository extends JpaRepository<Message, Integer> {
//    List<Message> findByChatOrderByMessageTimeAsc(Integer chatId);
//}

package com.example.chatichek.repository;

import com.example.chatichek.entity.Message;
import com.example.chatichek.entity.Chatic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    // Поиск сообщений по чату
    List<Message> findByChatChatIdOrderByMessageTimeAsc(Integer chatId);

    // Поиск сообщений по отправителю и чату
    List<Message> findBySenderUserIdAndChatChatIdOrderByMessageTimeAsc(Integer senderId, Integer chatId);

    // Поиск сообщений по тексту
    List<Message> findByMessageTextContainingIgnoreCase(String text);

    Message findByMessageId(Integer messageId);

}