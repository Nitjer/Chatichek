package com.example.chatichek.controller;

import com.example.chatichek.entity.Chatic;
import com.example.chatichek.entity.Message;
import com.example.chatichek.entity.User;
import com.example.chatichek.repository.MessageRepository;
import com.example.chatichek.repository.UserRepository;
import com.example.chatichek.service.ChatService;
import com.example.chatichek.service.MessageService;
import com.example.chatichek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final MessageService messageService;
    private final UserService userService;

    @Autowired
    public ChatController(ChatService chatService, UserRepository userRepository, MessageRepository messageRepository, MessageService messageService, UserService userService) {
        this.chatService = chatService;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    public String chatPage(@RequestParam(value = "chatId", required = false) Integer chatId,
                           Model model, HttpSession session) {

        // Получаем список чатов
        List<Chatic> chats = chatService.getAllChats();
        model.addAttribute("chats", chats);

        if (chatId != null) {
            // Загружаем сообщения для выбранного чата
            List<Message> messages = chatService.getMessagesByChatId(chatId);
            model.addAttribute("messages", messages);
            model.addAttribute("currentChatId", chatId);
        }

        // Загружаем пользователя из сессии
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("chatId") Integer chatId,
                              @RequestParam("messageText") String messageText,
                              HttpSession session) {

        // Получаем пользователя из сессии
        User user = (User) session.getAttribute("user");

        // Создаем и сохраняем новое сообщение
        Message message = new Message();
        message.setIdSender(user.getUserId());
        message.setIdChat(chatId);
        message.setMessageText(messageText);
        message.setMessageTime(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

        chatService.saveMessage(message);

        return "redirect:/chat?chatId=" + chatId; // Перенаправляем обратно в чат
    }
    @GetMapping("/messages")
    public String getMessages(@RequestParam("chatId") Integer chatId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<Message> messages = chatService.getMessagesByChatId(chatId);
        model.addAttribute("messages", messages);
        model.addAttribute("user", user);

        return "chat :: #messages-container"; // Возвращает только контейнер сообщений
    }

    @DeleteMapping("/chat/delete/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable Integer messageId, String nickname) {
        User currentUser = userService.findByUsername(nickname);
        Message message = messageService.findByMessageId(messageId);

        if (currentUser.isRole() || message.getSender().getUserId().equals(currentUser.getUserId())) {
            messageService.deleteById(messageId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}

//@Controller
//@RequestMapping("/chat")
//public class ChatController {
//
//    private final ChatService chatService;
//    private final MessageRepository messageRepository;
//    private final MessageService messageService;
//    private final UserService userService;
//
//    @Autowired
//    public ChatController(ChatService chatService, MessageRepository messageRepository,
//                          MessageService messageService, UserService userService) {
//        this.chatService = chatService;
//        this.messageRepository = messageRepository;
//        this.messageService = messageService;
//        this.userService = userService;
//    }
//
//    // Страница чата
//    @GetMapping
//    public String chatPage(@RequestParam(value = "chatId", required = false) Integer chatId,
//                           Model model, HttpSession session, Principal principal) {
//        // Получаем текущего пользователя по логину
//        if (principal == null) {
//            return "redirect:/login"; // Если не авторизован — редирект на логин
//        }
//
//        User user = userService.findByUsername(principal.getName());
//        model.addAttribute("user", user);
//        model.addAttribute("isAdmin", user.isRole()); // Проверка роли админа
//
//        // Загружаем список чатов
//        List<Chatic> chats = chatService.getAllChats();
//        model.addAttribute("chats", chats);
//
//        if (chatId != null) {
//            // Загружаем сообщения для выбранного чата
//            List<Message> messages = chatService.getMessagesByChatId(chatId);
//            model.addAttribute("messages", messages);
//            model.addAttribute("currentChatId", chatId);
//        }
//
//        return "chat";
//    }
//
//    // Отправка сообщения
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam("chatId") Integer chatId,
//                              @RequestParam("messageText") String messageText,
//                              Principal principal) {
//        // Получаем текущего пользователя
//        User user = userService.findByUsername(principal.getName());
//
//        // Создаем новое сообщение
//        Message message = new Message();
//        message.setIdSender(user.getUserId());
//        message.setIdChat(chatId);
//        message.setMessageText(messageText);
//        message.setMessageTime(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
//
//        chatService.saveMessage(message);
//
//        return "redirect:/chat?chatId=" + chatId; // Перенаправляем обратно в чат
//    }
//
//    // Удаление сообщения
//    @DeleteMapping("/delete/{messageId}")
//    public ResponseEntity<?> deleteMessage(@PathVariable Integer messageId, Principal principal) {
//        // Получаем текущего пользователя
//        User currentUser = userService.findByUsername(principal.getName());
//        Message message = messageService.findByMessageId(messageId);
//
//        // Проверка прав на удаление (админ или автор сообщения)
//        if (currentUser.isRole() || message.getSender().getUserId().equals(currentUser.getUserId())) {
//            messageService.deleteById(messageId);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Нет прав
//    }
//
//    // Загрузка сообщений
//    @GetMapping("/messages")
//    public String getMessages(@RequestParam("chatId") Integer chatId, Model model, Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//
//        List<Message> messages = chatService.getMessagesByChatId(chatId);
//        model.addAttribute("messages", messages);
//        model.addAttribute("user", user);
//
//        return "chat :: #messages-container"; // Возвращаем фрагмент сообщений
//    }
//}
